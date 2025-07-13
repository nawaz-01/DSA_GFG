
// Given an integer n, calculate the sum of series 13 + 23 + 33 + 43 + … till n-th term.
// The sum of the first n natural numbers raised to the power of 3.
// Example: If n = 3, the output should be 36 (1^3 + 2^3 + 3^3 = 1 + 8 + 27 = 36).
// If n is 0, the output should be 0.
// Constraints: 0 <= n <= 10^5
// Time Complexity: O(n)
// Space Complexity: O(1)

package P02_Mathematics_Basics;

public class Sum_of_first_N_terms {
    // User function Template for Java

    class Solution {
        int sumOfSeries(int n) {
            // code here
            int cubesum = 0;
            if (n == 1)
                return 1;
            for (int i = 1; i <= n; i++) {
                cubesum += Math.pow(i, 3);
            }
            return cubesum;
        }
    }
}
