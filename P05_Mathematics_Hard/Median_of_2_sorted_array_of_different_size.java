
// Given two sorted arrays a[] and b[], find and return the median of the combined array after merging them into a single sorted array.

// Examples:

// Input: a[] = [-5, 3, 6, 12, 15], b[] = [-12, -10, -6, -3, 4, 10]
// Output: 3
// Explanation: The merged array is [-12, -10, -6, -5, -3, 3, 4, 6, 10, 12, 15]. So the median of the merged array is 3.
// Input: a[] = [2, 3, 5, 8], b[] = [10, 12, 14, 16, 18, 20]
// Output: 11
// Explanation: The merged array is [2, 3, 5, 8, 10, 12, 14, 16, 18, 20]. So the median of the merged array is (10 + 12) / 2 = 11.
// Input: a[] = [], b[] = [2, 4, 5, 6]
// Output: 4.5
// Explanation: The merged array is [2, 4, 5, 6]. So the median of the merged array is (4 + 5) / 2 = 4.5.

package P05_Mathematics_Hard;

public class Median_of_2_sorted_array_of_different_size {

    class Solution {
        public double medianOf2(int a[], int b[]) { // <-- capital 'O'
            int n = a.length;
            int m = b.length;
            int[] merged = new int[n + m];
            int i = 0, j = 0, k = 0;

            while (i < n && j < m) {
                if (a[i] < b[j]) {
                    merged[k++] = a[i++];
                } else {
                    merged[k++] = b[j++];
                }
            }

            while (i < n)
                merged[k++] = a[i++];
            while (j < m)
                merged[k++] = b[j++];

            int total = n + m;
            if (total % 2 == 1) {
                return merged[total / 2];
            } else {
                return (merged[total / 2 - 1] + merged[total / 2]) / 2.0;
            }
        }
    }

}

// Note: The code above merges two sorted arrays and finds the median of the
// merged array.
// The merging process is done in O(n + m) time complexity, where n and m
// are the sizes of the two arrays. The median is then calculated based on
// whether the total number of elements is odd or even.
// The solution is efficient and straightforward, leveraging the properties of
// sorted arrays to merge them efficiently.
// The median is returned as a double to accommodate cases where the median is
// not an integer (e.g., when the total number of elements is even).
// The class and method names are kept consistent with the problem statement for
// clarity and ease of understanding.
// The solution is encapsulated within a class named `Solution`, which is a
// common practice in competitive programming and interview questions to allow
// for easy instantiation and testing.
// The code is structured to handle edge cases, such as when one of the arrays
// is empty, ensuring that the median is calculated correctly in all scenarios.
// The code is written in Java, following the conventions and syntax of the
// language, making it suitable for execution in a Java environment.
// The solution is designed to be clear and maintainable, with appropriate
// variable names and comments to explain the logic.
// The code is ready for integration into a larger codebase or for use in
// competitive programming contests, where merging sorted arrays and finding
// medians are common tasks.
// The code is self-contained and does not rely on any external libraries or
// dependencies, making it easy to run in any standard Java environment.
// The code is structured to be efficient and straightforward, focusing on
// clarity and maintainability.
