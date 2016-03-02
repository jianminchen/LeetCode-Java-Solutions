/**
 * @see <a href="https://leetcode.com/problems/minimum-path-sum/">Minimum Path Sum</a>
 */

public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null) throw new NullPointerException();
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int[][] minPSum = new int[grid.length][grid[0].length];
        // initialize the last element
        minPSum[grid.length - 1][grid[0].length - 1] = grid[grid.length - 1][grid[0].length - 1];
        // initialize the last column
        for (int i = grid.length - 2; i >= 0; --i) {
            minPSum[i][grid[0].length - 1] = minPSum[i + 1][grid[0].length -1] + grid[i][grid[0].length - 1];
        }
        // initialize the last row
        for (int j = grid[0].length - 2; j >= 0; --j) {
            minPSum[grid.length - 1][j] = minPSum[grid.length - 1][j + 1] + grid[grid.length - 1][j];
        }
        // dp.
        for (int i = grid.length - 2; i >= 0; --i) {
            for (int j = grid[0].length - 2; j >= 0; --j) {
                minPSum[i][j] = Math.min(minPSum[i + 1][j], minPSum[i][j + 1]) + grid[i][j];
            }
        }
        return minPSum[0][0];
    }
}
