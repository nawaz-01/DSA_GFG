
// Given an array arr[] and an integer k where k is smaller than the size of the array, your task is to find the kth smallest element in the given array.

// Follow up: Don't solve it using the inbuilt sort function.

// Examples :

// Input: arr[] = [7, 10, 4, 3, 20, 15], k = 3
// Output: 7
// Explanation: 3rd smallest element in the given array is 7.
// Input: arr[] = [2, 3, 1, 20, 15], k = 4 
// Output: 15
// Explanation: 4th smallest element in the given array is 15.
// Constraints:
// 1 <= arr.size <= 106
// 1<= arr[i] <= 106
// 1 <= k <= n

package P04_Mathematics_Medium;

import java.util.PriorityQueue;

public class Kth_Smallest {

    class Solution {
        public static int kthSmallest(int[] arr, int k) {
            // Min-Heap to store array elements
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            // Add all elements to the heap
            for (int num : arr) {
                minHeap.add(num);
            }

            // Remove the smallest (k - 1) elements
            for (int i = 0; i < k - 1; i++) {
                minHeap.poll();
            }

            // The next element is the kth smallest
            return minHeap.peek();
        }
    }

}

// Time Complexity: O(n log n) due to heap operations
// Space Complexity: O(n) for storing the elements in the heap
// Note: This solution uses a min-heap to efficiently find the kth smallest
// element without sorting the entire array.
// This approach is efficient for large arrays and avoids the overhead of
// sorting, making it suitable for the problem constraints.
// The solution uses a priority queue (min-heap) to efficiently find the kth
// smallest element in the array.
// The kth smallest element is found by removing the smallest elements from the
// heap until we reach the kth one.