
// You are given a 2D matrix mat[][] of size n x m. The task is to modify the matrix such that if mat[i][j] is 0, all the elements in the i-th row and j-th column are set to 0.

// Examples:

// Input:  1  -1   1
//        -1   0   1
//         1  -1   1

// Output: 1  0  1
//         0  0  0
//         1  0  1

// Explanation: mat[1][1] = 0, so all elements in row 1 and column 1 are updated to zeroes.

// Input:  0  1  2  0
//         1  2  6  2
//         1  3  1  8

// Output: 0  0  0  0
//         0  2  6  0
//         0  3  1  0

// Explanation: mat[0][0] and mat[0][3] are 0s, so all elements in row 0, column 0 and column 3 are updated to zeroes.

package Problem_Of_The_Day_Streak;

public class Set_Matrix_Zeros {
    class Solution {
        public void setMatrixZeroes(int[][] mat) {
            int n = mat.length;
            int m = mat[0].length;

            boolean[] row = new boolean[n];
            boolean[] col = new boolean[m];

            // First pass to find all rows and columns that should be zero
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (mat[i][j] == 0) {
                        row[i] = true;
                        col[j] = true;
                    }
                }
            }

            // Second pass to set the rows and columns to zero
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (row[i] || col[j]) {
                        mat[i][j] = 0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // Example usage
        Set_Matrix_Zeros obj = new Set_Matrix_Zeros();
        Solution sol = obj.new Solution();

        int[][] matrix = {
                { 1, -1, 1 },
                { -1, 0, 1 },
                { 1, -1, 1 }
        };

        sol.setMatrixZeroes(matrix);

        // Print modified matrix
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

}

// This code defines a method to set entire rows and columns to zero in a matrix
// if any element in that row or column is zero.
// The solution uses two boolean arrays to track which rows and columns need to
// be set to zero, ensuring that the original matrix is not modified during the
// first pass. After identifying the rows and columns, it modifies the matrix in
// a second pass. This approach ensures that the algorithm runs efficiently with
// a time complexity of O(n * m) and space complexity of O(n + m).
// The main method demonstrates how to use the Solution class to modify a sample
// matrix and print the result.
