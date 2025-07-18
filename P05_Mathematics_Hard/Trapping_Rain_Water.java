
// Given an array arr[] with non-negative integers representing the height of blocks. If the width of each block is 1, compute how much water can be trapped between the blocks during the rainy season. 

// Note: The width of each block is 1, and the height of each block is given by the elements of the array.
// Example: For arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}, the output is 6.
// The water trapped is calculated based on the heights of the blocks and the gaps between them.
// The water trapped at each block is determined by the minimum of the maximum heights to the left and right of that block, minus the height of the block itself.
// The total water trapped is the sum of water trapped at each block.
// Note: The input array is guaranteed to have at least one element.
// The solution should handle edge cases such as when the array is empty or has only one element.
// The solution should be efficient and handle large arrays.
// The solution should be implemented in Java and follow best practices for readability and maintainability.
// Note: This code is a placeholder for the Trapping Rain Water problem.
// The solution should be implemented in a class named Trapping_Rain_Water.
// The solution should include a method that takes the array as input and returns the total amount of water trapped.
// The solution should be efficient and handle large arrays.
// The solution should be implemented in a class named Trapping_Rain_Water.
// Note: This code is a placeholder for the Trapping Rain Water problem.
// The solution should include a method that takes the array as input and returns the total amount of water trapped.
// The solution should be efficient and handle large arrays.
// The solution should be implemented in a class named Trapping_Rain_Water.
// The solution should include a method that takes the array as input and returns the total amount of water trapped.
// The solution should be efficient and handle large arrays.
// The solution should be implemented in a class named Trapping_Rain_Water.
// The solution should include a method that takes the array as input and returns the total amount of water trapped.
// The solution should be efficient and handle large arrays.
// The solution should be implemented in a class named Trapping_Rain_Water.
// The solution should include a method that takes the array as input and returns the total amount of water trapped.
// The solution should be efficient and handle large arrays.
// The solution should be implemented in a class named Trapping_Rain_Water.
// The solution should include a method that takes the array as input and returns the total amount of water trapped.
// The solution should be efficient and handle large arrays.
// The solution should be implemented in a class named Trapping_Rain_Water.
// The solution should include a method that takes the array as input and returns the total amount of water trapped.
// The solution should be efficient and handle large arrays.
// The solution should be implemented in a class named Trapping_Rain_Water.
// The solution should include a method that takes the array as input and returns the total amount of water trapped.
// The solution should be efficient and handle large arrays.
// The solution should be implemented in a class named Trapping_Rain_Water.

package P05_Mathematics_Hard;

public class Trapping_Rain_Water {

    // Method to compute the total amount of water trapped
    public int trap(int[] arr) {
        int n = arr.length;
        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int waterTrapped = 0;

        while (left < right) {
            if (arr[left] < arr[right]) {
                if (arr[left] >= leftMax) {
                    leftMax = arr[left];
                } else {
                    waterTrapped += leftMax - arr[left];
                }
                left++;
            } else {
                if (arr[right] >= rightMax) {
                    rightMax = arr[right];
                } else {
                    waterTrapped += rightMax - arr[right];
                }
                right--;
            }
        }

        return waterTrapped;
    }

}
