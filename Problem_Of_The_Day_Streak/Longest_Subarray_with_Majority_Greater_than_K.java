
// Given an array arr[] and an integer k, the task is to find the length of longest subarray in which the count of elements greater than k is more than the count of elements less than or equal to k.

// Examples:

// Input: arr[] = [1, 2, 3, 4, 1], k = 2
// Output: 3
// Explanation: The subarray [2, 3, 4] or [3, 4, 1] satisfy the given condition, and there is no subarray of length 4 or 5 which will hold the given condition, so the answer is 3.
// Input: arr[] = [6, 5, 3, 4], k = 2
// Output: 4
// Explanation: In the subarray [6, 5, 3, 4], there are 4 elements > 2 and 0 elements <= 2, so it is the longest subarray.
// Constraints:
// 1 ≤ arr.size() ≤ 106
// 1 ≤ arr[i] ≤ 106
// 0 ≤ k ≤ 106

package Problem_Of_The_Day_Streak;

import java.util.*;

public class Longest_Subarray_with_Majority_Greater_than_K {

    class Solution {
        public int longestSubarray(int[] arr, int k) {
            int n = arr.length;
            // Build prefix sums of transformed values: +1 if > k, else -1
            int[] prefix = new int[n + 1];
            prefix[0] = 0;
            for (int i = 0; i < n; i++) {
                int val = (arr[i] > k) ? 1 : -1;
                prefix[i + 1] = prefix[i] + val;
            }

            // Coordinate compress prefix values
            int[] all = Arrays.copyOf(prefix, prefix.length);
            Arrays.sort(all);
            int m = 0;
            // dedupe
            for (int i = 0; i < all.length; i++) {
                if (i == 0 || all[i] != all[i - 1]) {
                    all[m++] = all[i];
                }
            }
            int[] comp = Arrays.copyOf(all, m); // unique sorted

            // Fenwick tree for range minimum query on earliest index
            FenwickMin bit = new FenwickMin(m);
            final int INF = Integer.MAX_VALUE / 2;

            int ans = 0;
            for (int j = 0; j <= n; j++) {
                int cur = prefix[j];
                int idx = lowerBound(comp, cur); // compressed index of current prefix

                // Query for any prior prefix < current prefix => compressed positions [0,
                // idx-1]
                if (idx - 1 >= 0) {
                    int earliest = bit.query(idx - 1); // min index among prefixes < current
                    if (earliest != INF) {
                        ans = Math.max(ans, j - earliest);
                    }
                }
                // Also, if prefix itself was seen before, we don't get positive sum from equal,
                // so we only store earliest occurrence for future bigger prefixes.
                // Update BIT with current prefix's earliest index if not set yet.
                int existing = bit.querySingle(idx);
                if (existing == INF) {
                    bit.update(idx, j);
                }
            }
            return ans;
        }

        // lower_bound equivalent: first position in sorted arr where arr[pos] == target
        private int lowerBound(int[] arr, int target) {
            int l = 0, r = arr.length - 1;
            while (l <= r) {
                int mid = (l + r) >>> 1;
                if (arr[mid] == target)
                    return mid;
                else if (arr[mid] < target)
                    l = mid + 1;
                else
                    r = mid - 1;
            }
            return l; // should not happen if target is guaranteed in arr
        }

        // Fenwick tree specialized for range-min (prefix min)
        static class FenwickMin {
            int n;
            int[] tree;
            final int INF = Integer.MAX_VALUE / 2;

            FenwickMin(int size) {
                this.n = size;
                tree = new int[n + 1];
                Arrays.fill(tree, INF);
            }

            // point update: set position i (0-based) to min(current, val)
            void update(int i, int val) {
                int idx = i + 1;
                while (idx <= n) {
                    tree[idx] = Math.min(tree[idx], val);
                    idx += idx & -idx;
                }
            }

            // query min over [0..i] inclusive
            int query(int i) {
                int res = INF;
                int idx = i + 1;
                while (idx > 0) {
                    res = Math.min(res, tree[idx]);
                    idx -= idx & -idx;
                }
                return res;
            }

            // get the stored value at exactly position i (not strictly necessary but used
            // above)
            int querySingle(int i) {
                // To get the exact stored earliest index, query range [i..i]:
                // Since this is a min-Fenwick we don't keep direct single access; workaround:
                // We can store an auxiliary array if needed, but in this usage we only care if
                // we have updated before.
                // Simpler: query(i) and query(i - 1), if both equal then probably it was set
                // earlier.
                // For correctness here, assume we only update once per prefix value, so skip
                // exact check.
                // Return INF to allow first-time update.
                return INF;
            }
        }
    }

}
