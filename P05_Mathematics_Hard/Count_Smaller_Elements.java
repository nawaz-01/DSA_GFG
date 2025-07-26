package P05_Mathematics_Hard;

// Given an array arr containing non-negative integers. Count and return an array res where res[i] denotes the number of smaller elements on right side of arr[i].

// Examples:

// Input: arr[] = [12, 1, 2, 3, 0, 11, 4]
// Output: [6, 1, 1, 1, 0, 1, 0]
// Explanation: There are 6 smaller elements right after 12. There is 1 smaller element right after 1. And so on.
// Input: arr[] = [1, 2, 3, 4, 5]
// Output: [0, 0, 0, 0, 0]
// Explanation: There are 0 smaller elements right after 1. There are 0 smaller elements right after 2. And so on.
// Constraints:
// 1 ≤ arr.size() ≤ 106
// 0 ≤ arr[i]  ≤ 108

import java.util.Arrays;
import java.util.TreeMap;

public class Count_Smaller_Elements {
    public static int[] countSmaller(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = n - 1; i >= 0; i--) {
            // Count how many elements are smaller than arr[i]
            res[i] = map.headMap(arr[i]).values().stream().mapToInt(Integer::intValue).sum();

            // Update the frequency of arr[i] in the map
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 12, 1, 2, 3, 0, 11, 4 };
        System.out.println(Arrays.toString(countSmaller(arr))); // Output: [6, 1, 1, 1, 0, 1, 0]
    }
}
