
// You are given a circular array arr[] of integers, find the maximum possible sum of a non-empty subarray. In a circular array, the subarray can start at the end and wrap around to the beginning. Return the maximum non-empty subarray sum, considering both non-wrapping and wrapping cases.

package P05_Mathematics_Hard;

public class Max_Circular_Subarray_Sum {

    // Method to find the maximum subarray sum using Kadane's algorithm
    public int maxSubarraySum(int[] arr) {
        int maxSoFar = arr[0];
        int currMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currMax = Math.max(arr[i], currMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, currMax);
        }

        return maxSoFar;
    }

    // Method to find the maximum circular subarray sum
    public int maxCircularSubarraySum(int[] arr) {
        int nonWrappedSum = maxSubarraySum(arr);

        // Find the total sum and the minimum subarray sum
        int totalSum = 0;
        int minSubarraySum = Integer.MAX_VALUE;
        int currMin = 0;

        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
            currMin = Math.min(arr[i], currMin + arr[i]);
            minSubarraySum = Math.min(minSubarraySum, currMin);
        }

        // If all numbers are negative, return the non-wrapped sum
        if (totalSum == minSubarraySum) {
            return nonWrappedSum;
        }

        // Return the maximum of non-wrapped and wrapped sums
        return Math.max(nonWrappedSum, totalSum - minSubarraySum);
    }

}
