// A beautiful matrix is defined as a square matrix in which the sum of elements
// in every row and every column is equal. Given a square matrix mat[][], your
// task is to determine the minimum number of operations required to make the
// matrix beautiful.
// In one operation, you are allowed to increment the value of any single cell
// by 1.

// Examples:

// Input: mat[][] = [[1, 2],
// [3, 4]]
// Output: 4
// Explanation:
// Increment value of cell(0, 0) by 3,
// Increment value of cell(0, 1) by 1.

// Matrix after the operations: [[4, 3],
// [3, 4]]

// Here, sum of each row and column is 7.
// Hence total 4 operation are required.

// Input: mat[][] = [[1, 2, 3],
// [4, 2, 3],
// [3, 2, 1]]
// Output: 6
// Explanation:
// Increment value of cell(0, 0) by 1,
// Increment value of cell(0, 1) by 2,
// Increment value of cell(2, 1) by 1,
// Increment value of cell(2, 2) by 2.

// Matrix after the operations: [[2, 4, 3],
// [4, 2, 3],
// [3, 3, 3]]

// Here, sum of each row and column is 9.
// Hence total 6 operation are required.
// Constraints:
// 1 ≤ mat.size() ≤ 900
// 0 ≤ mat[i][j] ≤ 106

package Problem_Of_The_Day_Streak;

class Solution {
    public static int balanceSums(int[][] mat) {
        // code here
        int max = 0;
        int n = mat.length;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += mat[i][j];
                // System.out.println(mat[i][j] + " ");
            }
            max = Math.max(max, sum);
            // System.out.println(sum);
        }
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += mat[j][i];
                // System.out.println(mat[i][j] + " ");
            }
            max = Math.max(max, sum);
            // System.out.println(sum);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += mat[i][j];
                // System.out.println(mat[i][j] + " ");
            }
            ans += (max - sum);
            // System.out.println(sum);
        }
        return ans;
    }
}

// Time Complexity: O(N^2), where N is the size of the matrix.
// Space Complexity: O(1), as we are using only a constant amount of extra
// space.
// The solution iterates through the matrix to calculate the sum of each row and
// column,
// and then computes the number of operations needed to make the matrix
// beautiful by
// ensuring that all rows and columns have the same sum, which is the maximum
// sum found.
// The approach is efficient and works well within the given constraints.
// The solution is designed to handle matrices of size up to 900x900, which is
// feasible
// within the time limits for competitive programming problems.