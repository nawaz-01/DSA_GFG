
// Given a number n, check if the number is perfect or not. A number is said to be perfect if sum of all its factors excluding the number itself is equal to the number.

package P03_Mathematics_Easy;

class Solution {
    static boolean isPerfect(int n) {
        // code here
        if (n <= 1) {
            return false;
        }
        int sum = 1;
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                sum = sum + i;
                if (i != n / i) {
                    sum = sum + (n / i);
                }
            }
        }
        return sum == n;
    }
};
