/**
 * @see <a href="https://leetcode.com/problems/rotate-image/">Rotate Image</a>
 */

public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null) throw new NullPointerException();
        // two flips do the job.
        // flip around the diagonal
        for (int i = 0; i <= matrix.length - 2; ++i) {
            for (int j = 0; j <= matrix.length - 2 - i; ++j) {
                swap(matrix, i, j, matrix.length - 1 - j, matrix.length - 1 - i);
            }
        }
        // flip around the middle horizontal line
        for (int i = 0; i < matrix.length / 2; ++i) {
            for (int j = 0; j < matrix.length; ++j) {
                swap(matrix, i, j, matrix.length - 1 - i, j);
            }
        }
    }
    
    private void swap(int[][] matrix, int i, int j, int ni, int nj) {
        matrix[i][j] = matrix[i][j] ^ matrix[ni][nj];
        matrix[ni][nj] = matrix[i][j] ^ matrix[ni][nj];
        matrix[i][j] = matrix[i][j] ^ matrix[ni][nj];
    }
}
