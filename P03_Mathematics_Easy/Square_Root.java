
// Given a positive integer n, find the square root of n. If n is not a perfect square, then return the floor value.

// Floor value of any number is the greatest Integer which is less than or equal to that number

// Example: If n = 4, the output should be 2 (since sqrt(4) = 2).
// If n = 8, the output should be 2 (since sqrt(8)
// is approximately 2.828, and the floor value is 2).
// If n = 0, the output should be 0.
// Constraints: 0 <= n <= 10^9

package P03_Mathematics_Easy;

public class Square_Root {

    class Solution {
        int floorSqrt(int n) {
            // code here
            double nn = n;
            return (int) Math.sqrt(nn);
        }
    }
}
