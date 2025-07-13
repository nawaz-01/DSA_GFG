// Given an integer n, your task is to compute the sum of all natural numbers from 1 to n (inclusive).
// If n is 0, the sum should be 0.

package P02_Mathematics_Basics;

public class Sum_of_Natural_Numbers {
    public static int findSum(int n) {
        return ((n * (n + 1)) / 2);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Sum of natural numbers from 1 to 5: " + findSum(5)); // Expected: 15
        System.out.println("Sum of natural numbers from 1 to 10: " + findSum(10)); // Expected: 55
        System.out.println("Sum of natural numbers from 1 to 0: " + findSum(0)); // Expected: 0
        System.out.println("Sum of natural numbers from 1 to 1: " + findSum(1)); // Expected: 1
    }
}
