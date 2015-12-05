/**
 * @see <a href="https://leetcode.com/problems/unique-paths-ii/">Unique Paths II</a>
 */

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] nums = new int[m][n]; // m rows, n columns.

        if (obstacleGrid[m - 1][n - 1] == 1) return 0;
        nums[m - 1][n - 1] = 1;
        for (int i = m - 2; i >= 0; --i) {
            if (obstacleGrid[i][n - 1] == 1) nums[i][n - 1] = 0;
            else nums[i][n - 1] = nums[i + 1][n - 1];
        }
        for (int j = n - 2; j >= 0; --j) {
            if (obstacleGrid[m - 1][j] == 1) nums[m - 1][j] = 0;
            else nums[m - 1][j] = nums[m - 1][j + 1];
        }
        for (int i = m - 2; i >= 0; --i) {
            for (int j = n - 2; j >= 0; --j) {
                if (obstacleGrid[i][j] == 1) nums[i][j] = 0;
                else {
                    nums[i][j] = nums[i + 1][j] + nums[i][j + 1];
                }
            }
        }
        return nums[0][0];
    }
}
