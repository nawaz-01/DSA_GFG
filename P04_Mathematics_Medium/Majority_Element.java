
// Given an array arr[]. Find the majority element in the array. If no majority element exists, return -1.

// Note: A majority element in an array is an element that appears strictly more than arr.size()/2 times in the array.

// Examples:

// Input: arr[] = [1, 1, 2, 1, 3, 5, 1]
// Output: 1
// Explanation: Since, 1 is present more than 7/2 times, so it is the majority element.
// Input: arr[] = [7]
// Output: 7
// Explanation: Since, 7 is single element and present more than 1/2 times, so it is the majority element.
// Input: arr[] = [2, 13]
// Output: -1
// Explanation: Since, no element is present more than 2/2 times, so there is no majority element.
// Constraints:
// 1 ≤ arr.size() ≤ 105
// 1 ≤ arr[i] ≤ 105

package P04_Mathematics_Medium;

public class Majority_Element {

    class Solution {
        int majorityElement(int arr[]) {
            int count = 0;
            int candidate = -1;

            // Phase 1: Find a candidate
            for (int num : arr) {
                if (count == 0) {
                    candidate = num;
                    count = 1;
                } else if (num == candidate) {
                    count++;
                } else {
                    count--;
                }
            }

            // Phase 2: Verify the candidate
            count = 0;
            for (int num : arr) {
                if (num == candidate) {
                    count++;
                }
            }

            if (count > arr.length / 2) {
                return candidate;
            } else {
                return -1;
            }
        }
    }

}

// Time Complexity: O(n), where n is the number of elements in the array.
// Space Complexity: O(1), as we are using a constant amount of space for
// variables
// Approach: The Boyer-Moore Voting Algorithm is used to find the majority
// element in linear time.
// The algorithm works in two phases: first, it identifies a candidate for the
// majority element,
// and then it verifies if that candidate is indeed the majority element by
// counting its occurrences.
// The candidate is selected by maintaining a count that increases when the
// current number matches the candidate
// and decreases when it does not. If the count reaches zero, a new candidate is
// selected.