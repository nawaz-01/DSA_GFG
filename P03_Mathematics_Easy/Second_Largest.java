
// Given an array of positive integers arr[], return the second largest element from the array. If the second largest element doesn't exist then return -1.

// Note: The second largest element should not be equal to the largest element.

// Examples:

// Input: arr[] = [12, 35, 1, 10, 34, 1]
// Output: 34
// Explanation: The largest element of the array is 35 and the second largest element is 34.
// Input: arr[] = [10, 5, 10]
// Output: 5
// Explanation: The largest element of the array is 10 and the second largest element is 5.
// Input: arr[] = [10, 10, 10]
// Output: -1
// Explanation: The largest element of the array is 10 and the second largest element does not exist.
// Constraints:
// 2 ≤ arr.size() ≤ 105
// 1 ≤ arr[i] ≤ 105

package P03_Mathematics_Easy;

public class Second_Largest {

    class Solution {
        public int getSecondLargest(int[] arr) {
            int largest = Integer.MIN_VALUE;
            int secondLargest = Integer.MIN_VALUE;

            for (int num : arr) {
                if (num > largest) {
                    secondLargest = largest;
                    largest = num;
                } else if (num > secondLargest && num != largest) {
                    secondLargest = num;
                }
            }

            return (secondLargest == Integer.MIN_VALUE) ? -1 : secondLargest;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Second_Largest().new Solution();
        int[] arr1 = { 12, 35, 1, 10, 34, 1 };
        System.out.println(solution.getSecondLargest(arr1)); // Output: 34

        int[] arr2 = { 10, 5, 10 };
        System.out.println(solution.getSecondLargest(arr2)); // Output: 5

        int[] arr3 = { 10, 10, 10 };
        System.out.println(solution.getSecondLargest(arr3)); // Output: -1
    }

}
