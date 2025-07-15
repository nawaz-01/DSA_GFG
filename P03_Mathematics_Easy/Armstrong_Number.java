// You are given a 3-digit number n, Find whether it is an Armstrong number or not.

// An Armstrong number of three digits is a number such that the sum of the cubes of its digits is equal to the number itself. 371 is an Armstrong number since 33 + 73 + 13 = 371. 

package P03_Mathematics_Easy;

// User function Template for Java
class Solution {
    static boolean armstrongNumber(int n) {
        // code here
        int sum = 0;
        int temp = n;

        while (n != 0) {
            int r = n % 10;
            sum = sum + (r * r * r);
            n = n / 10;
        }

        return sum == temp;
    }
}