
// You are given an integer array arr[]. You need to find the maximum sum of a subarray (containing at least one element) in the array arr[].

// Note : A subarray is a continuous part of an array.

// Kadane's Algorithm is used to solve this problem efficiently.

package P04_Mathematics_Medium;

public class Kadanes_Algorithm {
    int maxSubarraySum(int[] arr) {
        int maxSoFar = arr[0];
        int currMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currMax = Math.max(arr[i], currMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, currMax);
        }

        return maxSoFar;
    }

}

// Time Complexity: O(n), where n is the number of elements in the array.
// Space Complexity: O(1), as we are using only a constant amount of space.
// This algorithm efficiently finds the maximum sum of a contiguous subarray
// using a single pass through the array.
// The algorithm maintains two variables: the maximum sum found so far and the
// current maximum sum ending at the current position.
// It updates these variables as it iterates through the array, ensuring that it
// always considers the best possible subarray sum.
// The algorithm is optimal for this problem and is widely used in competitive
// programming and interviews.
// Example usage:
// Kadanes_Algorithm ka = new Kadanes_Algorithm();
// int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
// int result = ka.maxSubarraySum(arr);
// The result will be 6, which is the sum of the subarray [4, -1, 2, 1].
// The algorithm is efficient and works well for both positive and negative
// integers in the array.
// The algorithm is based on the principle that if the current maximum sum
// becomes negative, it should be reset to the current element,
// as starting a new subarray from that point may yield a higher sum.
// The algorithm is robust and handles edge cases, such as arrays with all
// negative numbers, by returning the maximum single element in such cases.
// The algorithm is a classic example of dynamic programming and is often used
// to teach the concept of optimal substructure in algorithms.
// The algorithm can be applied to various real-world problems, such as finding
// the maximum profit in stock trading scenarios,
// where the array represents daily stock prices and the goal is to find the
// maximum profit from a single buy-sell transaction.
// The algorithm is also useful in scenarios where you need to analyze trends in
// data, such as finding the maximum gain in a series of measurements or scores.
// The algorithm is efficient and can handle large arrays due to its linear time
// complexity, making it suitable for competitive programming and real-time
// applications.
// The algorithm can be extended to find the starting and ending indices of the
// maximum subarray, if needed, by keeping track of the indices during the
// iteration.
