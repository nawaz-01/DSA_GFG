
// Given a number, in the form of an array Num[] of size N containing digits from 1 to 9(inclusive). The task is to find the next smallest palindrome strictly larger than the given number.

// Example 1:

// Input:
// N = 11
// Num[] = {9, 4, 1, 8, 7, 9, 7, 8, 3, 2, 2}
// Output: 9 4 1 8 8 0 8 8 1 4 9
// Explanation: Next smallest palindrome is
// 9 4 1 8 8 0 8 8 1 4 9
// Example 2:

// Input:
// N = 5
// Num[] = {2, 3, 5, 4, 5}
// Output: 2 3 6 3 2
// Explanation: Next smallest palindrome is
// 2 3 6 3 2

package P05_Mathematics_Hard;

import java.util.Vector;

public class Next_Smallest_Palindrome {

    class Solution {
        Vector<Integer> generateNextPalindrome(int num[], int n) {
            Vector<Integer> result = new Vector<>();

            // Edge case: all digits are 9 (like 9, 99, 999)
            boolean allNine = true;
            for (int digit : num) {
                if (digit != 9) {
                    allNine = false;
                    break;
                }
            }
            if (allNine) {
                result.add(1);
                for (int i = 1; i < n; i++) {
                    result.add(0);
                }
                result.add(1);
                return result;
            }

            // Step 1: Copy left half to right half
            int[] palin = num.clone();
            for (int i = 0; i < n / 2; i++) {
                palin[n - 1 - i] = palin[i];
            }

            // Step 2: Compare with original
            boolean isGreater = false;
            for (int i = 0; i < n; i++) {
                if (palin[i] > num[i]) {
                    isGreater = true;
                    break;
                } else if (palin[i] < num[i]) {
                    break;
                }
            }

            // Step 3: If not greater, increment the middle
            if (!isGreater) {
                int carry = 1;
                int mid = n / 2;

                if (n % 2 == 1) {
                    palin[mid] += carry;
                    carry = palin[mid] / 10;
                    palin[mid] %= 10;
                    int i = mid - 1;
                    int j = mid + 1;
                    while (i >= 0) {
                        palin[i] += carry;
                        carry = palin[i] / 10;
                        palin[i] %= 10;
                        palin[j] = palin[i];
                        i--;
                        j++;
                    }
                } else {
                    int i = mid - 1;
                    int j = mid;
                    while (i >= 0) {
                        palin[i] += carry;
                        carry = palin[i] / 10;
                        palin[i] %= 10;
                        palin[j] = palin[i];
                        i--;
                        j++;
                    }
                }
            }

            for (int val : palin)
                result.add(val);
            return result;
        }
    }

    public static void main(String[] args) {
        // Example usage
        Solution solution = new Next_Smallest_Palindrome().new Solution();
        int[] num = { 9, 4, 1, 8, 7, 9, 7, 8, 3, 2, 2 };
        Vector<Integer> result = solution.generateNextPalindrome(num, num.length);
        System.out.println(result);
    }

}
