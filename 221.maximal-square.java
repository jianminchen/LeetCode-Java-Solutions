/**
 * @see <a href="https://leetcode.com/problems/maximal-square/">Maximal Square</a>
 */

public class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == '1') {
                    max = Math.max(max, expand(matrix, i, j));
                }
            }
        }
        return max;
    }
    public int expand(char[][] matrix, int i, int j) {
        int len = 1; // the length of the square.
        while (true) {
            boolean canExpand = true;
            if (i + len >= matrix.length || j + len >= matrix[0].length ||
            (i + len < matrix.length && j + len < matrix[0].length && matrix[i + len][j + len] != '1')) break;
            // i + len < matrix.length
            for (int tj = j; tj < j + len; ++tj) {
                if (matrix[i + len][tj] != '1') {
                    canExpand = false;
                    break;
                }
            }
            for (int ti = i; ti < i + len; ++ti) {
                if (matrix[ti][j + len] != '1') {
                    canExpand = false;
                    break;
                }
            }
            if (canExpand) ++len;
            else break;
        }
        return len * len;
    }
}
