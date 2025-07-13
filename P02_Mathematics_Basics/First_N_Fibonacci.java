
// Given a number n, return an array containing the first n Fibonacci numbers.

// Note: The first two numbers of the series are 0 and 1.

// The Fibonacci sequence is defined as follows:
// F(0) = 0, F(1) = 1
// F(n) = F(n-1) + F(n-2) for n > 1
// Example: If n = 5, the output should be [0, 1, 1, 2, 3].
// If n is 0, the output should be an empty array.  
// If n is 1, the output should be [0].
// If n is 2, the output should be [0, 1].  
// If n is negative, the output should be an empty array.
// Constraints: 0 <= n <= 10^5
// Time Complexity: O(n)
// Space Complexity: O(n)

package P02_Mathematics_Basics;

public class First_N_Fibonacci {
    // User function Template for Java

    class Solution {
        // Function to return list containing first n fibonacci numbers.
        public static int[] fibonacciNumbers(int n) {
            // Your code here
            int[] ans = new int[n];
            ans[0] = 0;
            if (n == 1)
                return ans;
            ans[1] = 1;
            if (n == 2)
                return ans;
            for (int i = 2; i < n; i++)
                ans[i] = ans[i - 1] + ans[i - 2];
            return ans;
        }
    }
}
