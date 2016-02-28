/**
 * @see <a href="https://leetcode.com/problems/range-sum-query-2d-immutable/">Range Sum Query 2D - Immutable</a>
 */

public class NumMatrix {
    int[][] sumMatrix;
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0
                || matrix[0] == null || matrix[0].length == 0) return;
        int m = matrix.length;
        int n = matrix[0].length;
        sumMatrix = new int[m + 1][n + 1];

        for (int i = 0; i <= n; ++i) sumMatrix[0][i] = 0;
        for (int i = 0; i <= m; ++i) sumMatrix[i][0] = 0;

        for (int i = 1; i <= m; ++i) {
            int sum = 0;
            for (int j = 1; j <= n; ++j) {
                sum += matrix[i - 1][j - 1];
                sumMatrix[i][j] = sum + sumMatrix[i - 1][j];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (sumMatrix == null) return 0;
        return sumMatrix[row2 + 1][col2 + 1] - sumMatrix[row1][col2 + 1] 
                - sumMatrix[row2 + 1][col1] + sumMatrix[row1][col1];
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
