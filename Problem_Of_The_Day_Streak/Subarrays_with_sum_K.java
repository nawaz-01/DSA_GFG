
// Given an unsorted array arr[] of integers, find the number of subarrays whose sum exactly equal to a given number k.

// Examples:

// Input: arr[] = [10, 2, -2, -20, 10], k = -10
// Output: 3
// Explaination: Subarrays: arr[0...3], arr[1...4], arr[3...4] have sum exactly equal to -10.
// Input: arr[] = [9, 4, 20, 3, 10, 5], k = 33
// Output: 2
// Explaination: Subarrays: arr[0...2], arr[2...4] have sum exactly equal to 33.
// Input: arr[] = [1, 3, 5], k = 0
// Output: 0
// Explaination: No subarray with 0 sum.
// Constraints:
// 1 ≤ arr.size() ≤ 105
// -103 ≤ arr[i] ≤ 103
// -105 ≤ k ≤ 105

package Problem_Of_The_Day_Streak;

import java.util.HashMap;

public class Subarrays_with_sum_K {

    class Solution {
        public int cntSubarrays(int[] arr, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int count = 0;
            int sum = 0;

            // Initialize with sum 0 occurring once
            map.put(0, 1);

            for (int num : arr) {
                sum += num;

                if (map.containsKey(sum - k)) {
                    count += map.get(sum - k);
                }

                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }

            return count;
        }
    }

}
