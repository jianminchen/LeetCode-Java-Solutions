/**
 * @see <a href="https://leetcode.com/problems/spiral-matrix-ii/">Spiral Matrix II</a>
 */

public class Solution {
    public int[][] generateMatrix(int n) {
        // fill int the array from the outmost circle to the innermost circle.
        // for each circle, fill in the first upper row, right column, lower row, left column, one by one.
        n = Math.abs(n);
        int layers = n >> 1;
        int num = 1;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < layers; ++i) {
            // the ith row;
            for (int j = i; j < n - 1 - i; ++j) {
                matrix[i][j] = num;
                ++num;
            }
            // the n - 1 - i th column:
            for (int j = i; j < n - 1 - i; ++j) {
                matrix[j][n - 1 - i] = num;
                ++num;
            }
            // the n - 1 - i th row;
            for (int j = i; j < n - 1 - i; ++j) {
                matrix[n - 1 - i][n - 1 - j] = num;
                ++num;
            }
            // the ith column
            for (int j = i; j < n - 1 - i; ++j) {
                matrix[n - 1 - j][i] = num;
                ++num;
            }
        }
        if (n % 2 == 1) matrix[n/2][n/2] = n * n;
        return matrix;
    }
}
