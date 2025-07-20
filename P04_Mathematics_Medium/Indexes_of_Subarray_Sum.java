// Given an array arr[] containing only non-negative integers, your task is to
// find a continuous subarray (a contiguous sequence of elements) whose sum
// equals a specified value target. You need to return the 1-based indices of
// the leftmost and rightmost elements of this subarray. You need to find the
// first subarray whose sum is equal to the target.

// Note: If no such array is possible then, return [-1].

// Example:
// Input: arr = [1, 2, 3, 7, 5
//         target = 12
// Output: [2, 4]

package P04_Mathematics_Medium;

import java.util.Arrays;

public class Indexes_of_Subarray_Sum {
    public static int[] subarraySum(int[] arr, int target) {
        int n = arr.length;
        int start = 0, end = 0, sum = 0;

        while (end < n) {
            sum += arr[end];

            while (sum > target && start <= end) {
                sum -= arr[start];
                start++;
            }

            if (sum == target) {
                return new int[] { start + 1, end + 1 }; // Convert to 1-based index
            }

            end++;
        }

        return new int[] { -1 }; // If no subarray found
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 7, 5 };
        int target = 12;
        System.out.println(Arrays.toString(subarraySum(arr, target))); // Output: [2, 4]
    }
}

// Time Complexity: O(n), where n is the number of elements in the array.
// Space Complexity: O(1), as we are using only a constant amount of extra space
// to store indices and sum.
// The algorithm uses a sliding window approach to find the subarray with the
// specified sum efficiently. It maintains a window defined by the indices
// `start` and `end`, adjusting the window size based on the current sum
// compared to the target. If the sum exceeds the target, it shrinks the window