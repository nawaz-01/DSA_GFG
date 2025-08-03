// You are given a 2D integer matrix mat[][] of size n × m and a list of q operations opr[][]. Each operation is represented as an array [v, r1, c1, r2, c2], where:

// v is the value to be added
// (r1, c1) is the top-left cell of a submatrix
// (r2, c2) is the bottom-right cell of the submatrix (inclusive)
// For each of the q operations, add v to every element in the submatrix from (r1, c1) to (r2, c2). Return the final matrix after applying all operations.

// Examples:

// Input: mat[][] = [[1, 2, 3],  opr[][] = [[2, 0, 0, 1, 1], [-1, 1, 0, 2, 2]]
//                  [1, 1, 0],
//                  [4,-2, 2]]

package Problem_Of_The_Day_Streak;

// import java.util.Arrays;

public class II_Difference_Array {

    public static int[][] applyOperations(int[][] mat, int[][] opr) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] diff = new int[n + 1][m + 1];

        for (int[] operation : opr) {
            int v = operation[0];
            int r1 = operation[1];
            int c1 = operation[2];
            int r2 = operation[3];
            int c2 = operation[4];

            diff[r1][c1] += v;
            diff[r1][c2 + 1] -= v;
            diff[r2 + 1][c1] -= v;
            diff[r2 + 1][c2 + 1] += v;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i > 0)
                    diff[i][j] += diff[i - 1][j];
                if (j > 0)
                    diff[i][j] += diff[i][j - 1];
                if (i > 0 && j > 0)
                    diff[i][j] -= diff[i - 1][j - 1];
                mat[i][j] += diff[i][j];
            }
        }

        return mat;
    }
}
// Output: [[3, 4, 3],
// [2, 2, -1],
// [3, -3, 1]]
// Explanation:

// Constraint:
// 1 ≤ n×m, q ≤ 105
// 0 ≤ r1 ≤ r2 ≤ n - 1
// 0 ≤ c1 ≤ c2 ≤ m - 1
// -104 ≤ mat[i][j], v ≤ 104
