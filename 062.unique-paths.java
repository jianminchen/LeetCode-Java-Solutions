/**
 * @see <a href="https://leetcode.com/problems/unique-paths/">Unique Paths</a>
 */

public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 1;
        int[] uniquePaths = new int[n];

        // set the last row
        for (int i = n - 1; i >= 0; --i) {
            uniquePaths[i] = 1;
        }
        
        for (int i = m - 2; i >= 0; --i) {
            for (int j = n - 2; j >= 0; --j) {
                uniquePaths[j] = uniquePaths[j] + uniquePaths[j + 1];
            }
        }
        return uniquePaths[0];
    }
}
