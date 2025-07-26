// Majority Element - More Than n/3

// Given an array arr[] consisting of n integers, the task is to find all the array elements which occurs more than floor(n/3) times.

// Note: The returned array of majority elements should be sorted.

// Examples:

// Input: arr[] = [2, 2, 3, 1, 3, 2, 1, 1]
// Output: [1, 2]
// Explanation: The frequency of 1 and 2 is 3, which is more than floor n/3 (8/3 = 2).
// Input:  arr[] = [-5, 3, -5]
// Output: [-5]
// Explanation: The frequency of -5 is 2, which is more than floor n/3 (3/3 = 1).
// Input:  arr[] = [3, 2, 2, 4, 1, 4]
// Output: []
// Explanation: There is no majority element.
// Constraint:
// 1 ≤ arr.size() ≤ 106
// -105 ≤ arr[i] ≤ 105

package Problem_Of_The_Day_Streak;

import java.util.*;

public class Majority_Element_more_than_n_by_three {
    public static List<Integer> majorityElement(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Count the frequency of each element
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        // Check which elements occur more than n/3 times
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > n / 3) {
                result.add(entry.getKey());
            }
        }

        // Sort the result before returning
        Collections.sort(result);
        return result;
    }
}

// Example usage
class Main {
    public static void main(String[] args) {
        int[] arr = { 2, 2, 3, 1, 3, 2, 1, 1 };
        List<Integer> majorityElements = Majority_Element_more_than_n_by_three.majorityElement(arr);
        System.out.println(majorityElements); // Output: [1, 2]

        int[] arr2 = { -5, 3, -5 };
        List<Integer> majorityElements2 = Majority_Element_more_than_n_by_three.majorityElement(arr2);
        System.out.println(majorityElements2); // Output: [-5]

        int[] arr3 = { 3, 2, 2, 4, 1, 4 };
        List<Integer> majorityElements3 = Majority_Element_more_than_n_by_three.majorityElement(arr3);
        System.out.println(majorityElements3); // Output: []
    }
}

// The code defines a method to find all elements in an array that occur more
// than n/3 times.
// It uses a HashMap to count the frequency of each element, checks which
// elements meet the criteria, and returns a sorted list of those elements.
// The main method demonstrates the usage of the majorityElement method with
// example inputs and prints the results.
// The code is efficient with a time complexity of O(n) for counting frequencies
// and O(k log k) for sorting the result, where k is the number of unique
// elements that occur more than n/3 times.
// The space complexity is O(n) for storing the frequency map.
// This solution is suitable for large arrays up to the constraint limits
// provided.
// The code is efficient with a time complexity of O(n) for counting frequencies
// and O(k log k) for sorting the result, where k is the number of unique
// elements that occur more than n/3 times.
// The space complexity is O(n) for storing the frequency map.
// This solution is suitable for large arrays up to the constraint limits
// provided.
// The code is efficient with a time complexity of O(n) for counting frequencies
// and O(k log k) for sorting the result, where k is the number of unique
// elements that occur more than n/3 times.
// The space complexity is O(n) for storing the frequency map.
// This solution is suitable for large arrays up to the constraint limits
// provided.