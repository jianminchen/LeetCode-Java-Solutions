/**
 * @see <a href="https://leetcode.com/problems/search-a-2d-matrix-ii/">Search a 2D Matrix II</a>
 */

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        return searchMatrix(matrix, target, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }
    public boolean searchMatrix(int[][] matrix, int target, int ia, int ja, int ib, int jb) {
        if (ia > ib || ja > jb) return false;
        if (target < matrix[ia][ja] || target > matrix[ib][jb]) return false;
        int imid = ia + ((ib - ia) >> 1);
        int jmid = ja + ((jb - ja) >> 1);
        if (target == matrix[imid][jmid]) {
            return true;
        } else if (target < matrix[imid][jmid]) {
            return searchMatrix(matrix, target, ia, ja, imid - 1, jb) 
                    || searchMatrix(matrix, target, imid, ja, ib, jmid - 1);
        } else { // target > matrix[imid][jmid]
            return searchMatrix(matrix, target, imid + 1, ja, ib, jmid)
                    || searchMatrix(matrix, target, ia, jmid + 1, ib, jb);
        }
    }
}
