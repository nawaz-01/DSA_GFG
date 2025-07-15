// You are given 2 numbers n and m, the task is to find n√m (nth root of m). If the root is not integer then returns -1.

package P03_Mathematics_Easy;

// User function Template for Java
import java.lang.Math;

class Solution {
    public int nthRoot(int n, int m) {
        // code here
        int low = 1, high = m;
        while (low <= high) {
            int mid = (low + high) / 2;
            int pow = (int) Math.pow(mid, n);
            if (pow == m)
                return mid;
            if (pow < m)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}