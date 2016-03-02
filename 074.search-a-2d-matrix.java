/**
 * @see <a href="https://leetcode.com/problems/search-a-2d-matrix/">Search a 2D Matrix</a>
 */

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // first get a possible candidate row.
        if (matrix == null) throw new NullPointerException();
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int low = 0; int high = matrix.length - 1;
        int rCand = -1;
        while (true) {
            if (low > high) return false;
            int mid = low + ((high - low) >> 1);
            if (target < matrix[mid][0]) {
                high = mid - 1;
            } else if (target >= matrix[mid][0] && target <= matrix[mid][matrix[0].length - 1]) {
                rCand = mid;
                break;
            } else {
                // target > matrix[mid][matrix[0].length - 1]
                low = mid + 1;
            }
        }
        // search for the target in the candidate row.
        low = 0; high = matrix[0].length - 1;
        while (true) {
            if (low > high) return false;
            int mid = low + ((high - low)>>1);
            if (target == matrix[rCand][mid]) return true;
            else if (target < matrix[rCand][mid]) high = mid - 1;
            else low = mid + 1;
        }
    }
}
