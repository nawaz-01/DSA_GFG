
// Given a positive integer n, The task is to find the value of Σi F(i) where i is from 1 to n and function F(i) is defined as the sum of all divisors of i.

// Example: If n = 5, the output should be 15 (F(1) + F(2) + F(3) + F(4) + F(5) = 1 + 3 + 4 + 7 + 6 = 21).
// If n is 0, the output should be 0.
// Constraints: 0 <= n <= 10^5
// Time Complexity: O(n^2) for the naive approach, which is inefficient for large n.
// Space Complexity: O(1) for the naive approach, as we are not using any
// additional data structures.
// For an efficient solution, consider using a sieve-like approach to calculate the sum of divisors for all numbers up to n in O(n log n) time.
// Note: The naive approach is not efficient for large n due to the quadratic time complexity.

package P03_Mathematics_Easy;

public class Sum_1_To_N_Divisor {
    class Solution {
        public static long sumOfDivisors(long n) {
            // code here
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += F(i);
            }

            return sum;

        }

        public static int F(int i) {
            int sum = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    sum += j;
                }
            }

            return sum;
        }
    }
}
