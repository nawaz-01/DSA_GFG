
// Given two numbers as strings s1 and s2. Calculate their Product.
// Note: The numbers can be negative and You are not allowed to use any built-in function or convert the strings to integers. There can be zeros in the begining of the numbers. You don't need to specify '+' sign in the begining of positive numbers.

// Example: If s1 = "12" and s2 = "34", the output should be "408" (12 * 34 = 408).
// If s1 = "0" and s2 = "123", the output should be
// "0" (0 * 123 = 0).

package P04_Mathematics_Medium;

public class Multiply_Two_String {
    class Solution {
        public String multiplyStrings(String s1, String s2) {
            // code here
            int signS1 = 1, signS2 = 1;
            while (s1.length() > 1 && s1.charAt(0) == '0' || s1.charAt(0) == '-') {
                if (s1.charAt(0) == '-')
                    signS1 = -1;
                s1 = s1.substring(1);
            }
            if (s1.charAt(0) == '0')
                return "0";
            while (s2.length() > 1 && s2.charAt(0) == '0' || s2.charAt(0) == '-') {
                if (s2.charAt(0) == '-')
                    signS2 = -1;
                s2 = s2.substring(1);
            }
            if (s2.charAt(0) == '0')
                return "0";
            StringBuilder ans = new StringBuilder();
            for (int i = s1.length() - 1; i >= 0; i--) {
                int carry = 0;
                int ind = s1.length() - i - 1;
                for (int j = s2.length() - 1; j >= 0; j--, ind++) {
                    int x = s1.charAt(i) - '0';
                    int y = s2.charAt(j) - '0';
                    int product = (x * y) + carry;
                    int digit = product % 10;
                    carry = product / 10;
                    if (ind >= ans.length()) {
                        ans.append(digit);
                    } else {
                        int z = ans.charAt(ind) - '0';
                        int sum = z + product;
                        int finalDigit = sum % 10;
                        carry = sum / 10;
                        ans.setCharAt(ind, (char) (finalDigit + '0'));
                    }
                }
                while (carry > 0) {
                    ans.append((char) (carry % 10 + '0'));
                    carry /= 10;
                }
            }

            if (signS1 * signS2 == -1)
                ans.append('-');
            return ans.reverse().toString();
        }
    }
}
