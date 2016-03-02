/**
 * @see <a href="https://leetcode.com/problems/set-matrix-zeroes/">Set Matrix Zeroes</a>
 */

public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null) throw new NullPointerException();
        if (matrix.length == 0 || matrix[0].length == 0) return;
        boolean firstColumnZero = false;
        for (int i = 0; i < matrix.length; ++i) {
            if (matrix[i][0] == 0) {
                firstColumnZero = true;
                break;
            }
        }
        boolean firstRowZero = false; // need to be initialized!!!!!
        for (int j = 0; j < matrix[0].length; ++j) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }
        
        // record use the first row, and first column.
        for (int i = 1; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    break;
                }
            }
        }
        for (int j = 1; j < matrix[0].length; ++j) {
            for (int i = 0; i < matrix.length; ++i) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    break;
                }
            }
        }
        // set some column to zeros.
        for (int i = 1; i < matrix.length; ++i) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < matrix[0].length; ++j) {
                    matrix[i][j] = 0;
                }
            }
        }
        // set some row to zeros. j < matrix[0].length, instead of j < matrix.length
        for (int j = 1; j < matrix[0].length; ++j) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < matrix.length; ++i) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstColumnZero) {
            for (int i = 0; i < matrix.length; ++i) {
                matrix[i][0] = 0;
            }
        }
        if (firstRowZero) {
            for (int j = 0; j < matrix[0].length; ++j) {
                matrix[0][j] = 0;
            }
        }
    }
}
