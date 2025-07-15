// Given three integers  'a' denotes the first term of an arithmetic sequence, 'c' denotes the common difference of an arithmetic sequence and an integer 'b'. you need to tell whether 'b' exists in the arithmetic sequence or not. Return 1 if b is present in the sequence. Otherwise, returns 0.

package P03_Mathematics_Easy;
// User function Template for Java

class Solution {
    static int inSequence(int a, int b, int c) {
        // code here
        int n = ((b - a) / c) + 1;

        int term = a + (n - 1) * c;

        if (b == term) {
            return 1;
        }

        return 0;
    }
}