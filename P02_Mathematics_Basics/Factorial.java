// Given a positive integer, n. Find the factorial of n.
// Factorial of n is defined as n! = n * (n-1) * (n-2) * ... * 1
// Factorial of 0 is defined as 1.
// Note: The factorial of a number can be very large, so return the result modulo 1000000007.
// User function Template for Java

package P02_Mathematics_Basics;

public class Factorial {
    static int factorial(int n) {
        // code here
        if (n == 0 || n == 1) {
            return 1;
        }
        int mod = 1000000007;
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result = (result * i) % mod;
        }
        return (int) result;
    }

}
