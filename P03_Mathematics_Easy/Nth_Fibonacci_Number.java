
// Given a non-negative integer n, your task is to find the nth Fibonacci number.

// The Fibonacci sequence is a sequence where the next term is the sum of the previous two terms. The first two terms of the Fibonacci sequence are 0 followed by 1. The Fibonacci sequence: 0, 1, 1, 2, 3, 5, 8, 13, 21

// The Fibonacci sequence is defined as follows:

// F(0) = 0
// F(1) = 1
// F(n) = F(n - 1) + F(n - 2) for n > 1

// Example: If n = 5, the output should be 5.
// If n is 0, the output should be 0.
// If n is 1, the output should be 1.
// If n is negative, the output should be -1.
// Constraints: 0 <= n <= 10^5
// Time Complexity: O(2^n) for the recursive approach, which is inefficient for large n.
// Space Complexity: O(n) for the recursive approach due to the call stack.
// For an efficient solution, consider using dynamic programming or memoization to reduce the time complexity to
// O(n) and space complexity to O(1) if you only keep track of the last two Fibonacci numbers.
// Note: The recursive approach is not efficient for large n due to exponential time complexity.

package P03_Mathematics_Easy;

public class Nth_Fibonacci_Number {
    // User function Template for Java

    class Solution {
        public int nthFibonacci(int n) {
            // code here
            if (n < 2)
                return n;
            return nthFibonacci(n - 1) + nthFibonacci(n - 2);
        }
    }
}
