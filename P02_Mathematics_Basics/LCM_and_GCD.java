package P02_Mathematics_Basics;

public class LCM_and_GCD {
    class Solution {
        public static int[] lcmAndGcd(int a, int b) {
            // code here
            int ab = a * b;
            int[] res = new int[2];
            while (a != 0 && b != 0) {
                if (a >= b) {
                    a %= b;
                } else {
                    b %= a;
                }
            }

            if (a == 0) {
                res[1] = b;
            } else {
                res[1] = a;
            }
            res[0] = ab / res[1];

            return res;
        }
    }
}
