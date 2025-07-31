
// You are given a 2D integer array intervals[][] of length n, where each intervals[i] = [start, end] represents a closed interval (i.e., all integers from start to end, inclusive). You are also given an integer k. An integer is called Powerful if it appears in at least k intervals. Find the maximum Powerful Integer.

// Note: If no integer occurs at least k times return -1.

// Examples:

// Input : n = 3, intervals[][] = [[1, 3], [4, 6], [3, 4]], k = 2
// Output: 4
// Explanation: Integers 3 and 4 appear in 2 intervals. The maximum is 4.
// Input : n = 4, intervals[][] = [[1, 4], [12, 45], [3, 8], [10, 12]], k = 3
// Output: -1
// Explanation: No integer appears in at least 3 intervals.
// Input : n = 5, intervals[][] = [[16, 21], [5, 8], [12, 17], [17, 29], [9, 24]], k = 3
// Output: 21
// Explanation: Integers 16, 17, 18, 19, 20 and 21 appear in at least 3 intervals. The maximum is 21.
// Constraints:
// 1 ≤ n ≤ 105
// 1 ≤ intervals[i][0] ≤ intervals[i][1] ≤ 109
// 1 ≤ k ≤ 105

package Problem_Of_The_Day_Streak;

import java.util.*;

public class Powerful_Integer {

    class Solution {
        public int powerfulInteger(int[][] intervals, int k) {
            TreeMap<Integer, Integer> map = new TreeMap<>();

            // Mark the changes at start and end+1
            for (int[] interval : intervals) {
                map.put(interval[0], map.getOrDefault(interval[0], 0) + 1);
                map.put(interval[1] + 1, map.getOrDefault(interval[1] + 1, 0) - 1);
            }

            int count = 0;
            int prev = -1;
            int result = -1;

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int point = entry.getKey();
                if (count >= k && prev != -1) {
                    result = Math.max(result, point - 1); // because 'point' is exclusive
                }
                count += entry.getValue();
                if (count >= k) {
                    prev = point; // mark start of a valid range
                } else {
                    prev = -1; // exit valid range
                }
            }

            return result;
        }
    }

}
