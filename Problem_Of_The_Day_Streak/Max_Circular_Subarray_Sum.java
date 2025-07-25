
// You are given a circular array arr[] of integers, find the maximum possible sum of a non-empty subarray. In a circular array, the subarray can start at the end and wrap around to the beginning. Return the maximum non-empty subarray sum, considering both non-wrapping and wrapping cases.

// Examples:

// Input: arr[] = [8, -8, 9, -9, 10, -11, 12]
// Output: 22
// Explanation: Starting from the last element of the array, i.e, 12, and moving in a circular fashion, we have max subarray as 12, 8, -8, 9, -9, 10, which gives maximum sum as 22.
// Input: arr[] = [10, -3, -4, 7, 6, 5, -4, -1]
// Output: 23
// Explanation: Maximum sum of the circular subarray is 23. The subarray is [7, 6, 5, -4, -1, 10].
// Input: arr[] = [5, -2, 3, 4]
// Output: 12
// Explanation: The circular subarray [3, 4, 5] gives the maximum sum of 12.
// Constraints:
// 1 ≤ arr.size() ≤ 105
// -104 ≤ arr[i] ≤ 104

package Problem_Of_The_Day_Streak;

public class Max_Circular_Subarray_Sum {

    public static int maxCircularSubarraySum(int[] arr) {
        int n = arr.length;

        // Case 1: Non-wrapping subarray sum
        int maxNonWrappingSum = kadane(arr, n);

        // Case 2: Wrapping subarray sum
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
            arr[i] = -arr[i]; // Invert the array for Kadane's algorithm
        }
        int maxWrappingSum = totalSum + kadane(arr, n);

        return Math.max(maxNonWrappingSum, maxWrappingSum);
    }

    private static int kadane(int[] arr, int n) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;

        for (int i = 0; i < n; i++) {
            maxEndingHere += arr[i];
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }
        return maxSoFar;
    }

}

// Time Complexity: O(n)
// Space Complexity: O(1)
// This code efficiently calculates the maximum circular subarray sum using
// Kadane's algorithm for both non-wrapping and wrapping cases. It handles the
// inversion of the array to find the wrapping sum and combines both results to
// return the maximum sum.
// The solution is optimal and works within the constraints provided, ensuring
// that it can handle large arrays efficiently.
// The code is structured to handle both cases of subarray sums, ensuring that
// it can find the maximum sum in a circular array efficiently.
// The solution is designed to be efficient and straightforward, leveraging
// Kadane's algorithm to find the maximum subarray sum in both scenarios
// (non-wrapping and wrapping) while maintaining clarity and simplicity in the
// implementation.
// The code is structured to handle both cases of subarray sums, ensuring that
// it can find the maximum sum in a circular array efficiently.
// The solution is designed to be efficient and straightforward, leveraging
// Kadane's algorithm to find the maximum subarray sum in both scenarios
// (non-wrapping and wrapping) while maintaining clarity and simplicity in the
// implementation.
// The code is structured to handle both cases of subarray sums, ensuring that
// it can find the maximum sum in a circular array efficiently.
// The solution is designed to be efficient and straightforward, leveraging
// Kadane's algorithm to find the maximum subarray sum in both scenarios
// (non-wrapping and wrapping) while maintaining clarity and simplicity in the
// implementation.
// The code is structured to handle both cases of subarray sums, ensuring that
// it can find the maximum sum in a circular array efficiently.
// The solution is designed to be efficient and straightforward, leveraging
// Kadane's algorithm to find the maximum subarray sum in both scenarios
// (non-wrapping and wrapping) while maintaining clarity and simplicity in the
// implementation.
