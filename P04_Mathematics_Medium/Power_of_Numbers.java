
// Given a number n, find the value of n raised to the power of its own reverse.
// Note: The result will always fit into a 32-bit signed integer.

// Example: If n = 12, the output should be 144 (12^21 = 144).
// If n = 0, the output should be 1 (0^0 is convention

package P04_Mathematics_Medium;

import java.math.*;

public class Power_of_Numbers {

    class Solution {
        public int reverse(int n) {
            // code here
            int a = 0;
            while (n > 0) {
                a = a * 10 + n % 10;
                n /= 10;
            }
            return a;
        }

        public int reverseExponentiation(int n) {
            // code here
            if (reverse(n) == 0)
                return 1;
            return (int) Math.pow(n, reverse(n));
        }
    }

}
