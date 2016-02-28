/**
 * @see <a href="https://leetcode.com/problems/sparse-matrix-multiplication/">Sparse Matrix Multiplication</a>
 */

public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] res = new int[A.length][B[0].length];
        boolean[] rowZero = new boolean[A.length];
        for (int i = 0; i < rowZero.length; ++i) rowZero[i] = true;
        for (int i = 0; i < rowZero.length; ++i) {
            for (int j = 0; j < A[0].length; ++j) {
                if (A[i][j] != 0) {
                    rowZero[i] = false;
                    break;
                }
            }
        }
        boolean[] columnZero = new boolean[B[0].length];
        for (int j = 0; j < columnZero.length; ++j) columnZero[j] = true;
        for (int j = 0; j < B[0].length; ++j) {
            for (int i = 0; i < B.length; ++i) {
                if (B[i][j] != 0) {
                    columnZero[j] = false;
                    break;
                }
            }
        }
        for (int i = 0; i < res.length; ++i) {
            for (int j = 0; j < res[0].length; ++j) {
                if (rowZero[i] || columnZero[j]) {
                    res[i][j] = 0;
                } else {
                    for (int k = 0; k < A[0].length; ++k) {
                        if (A[i][k] != 0 && B[k][j] != 0) {
                            res[i][j] += A[i][k] * B[k][j];
                        }
                    }
                }
            }
        }
        return res;
    }
}
