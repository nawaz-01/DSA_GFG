
// Given an array arr[] containing only 0s, 1s, and 2s. Sort the array in ascending order.

// You need to solve this problem without utilizing the built-in sort function.

// Examples:

// Input: arr[] = [0, 1, 2, 0, 1, 2]
// Output: [0, 0, 1, 1, 2, 2]
// Explanation: 0s 1s and 2s are segregated into ascending order.
// Input: arr[] = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]
// Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2]
// Explanation: 0s 1s and 2s are segregated into ascending order.

// Follow up: Could you come up with a one-pass algorithm using only constant extra space?
// Constraints:
// 1 <= arr.size() <= 106
// 0 <= arr[i] <= 2

package P04_Mathematics_Medium;

public class Sort_0s_1s_and_2s {
    class Solution {
        // Function to sort an array of 0s, 1s, and 2s
        public void sort012(int[] arr) {
            // code here
            int low = 0, mid = 0, high = arr.length - 1;

            while (mid <= high) {
                if (arr[mid] == 0) {
                    int temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    low++;
                    mid++;
                } else if (arr[mid] == 1) {
                    mid++;
                } else {
                    int temp = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp;
                    high--;
                }
            }
        }
    }

    // Time Complexity: O(N), where N is the size of the array.
    // Space Complexity: O(1), as we are using only a constant amount of extra
    // space.

}
