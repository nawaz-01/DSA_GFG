
// Given two integer values n and r, the task is to find the value of Binomial Coefficient nCr

// A binomial coefficient nCr can be defined as the coefficient of xr in the expansion of (1 + x)n that gives the number of ways to choose r objects from a set of n objects without considering the order.
// The binomial coefficient nCr is calculated as : C(n,r) = n! / r! * (n-r) !
// Note: If r is greater than n, return 0.
// It is guaranteed that the value of nCr will fit within a 32-bit integer.

// Example: If n = 5 and r = 2, the output should be 10 (5C2 = 5! / (2! * (5-2)!) = 10).
// If n is 0 or r is 0, the output should be 1.

package P04_Mathematics_Medium;

public class nCr {
    class Solution {
        public int nCr(int n, int r) {
            // code here
            if (r > n)
                return 0;
            if (r == 0 || r == n)
                return 1;

            int lim = Math.min(r, n - r);

            long num = 1;
            for (int i = 0; i < lim; i++) {
                num *= (n - i);
                num /= (i + 1);
            }

            return (int) num;
        }
    }
}
