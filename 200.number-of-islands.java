/**
 * @see <a href="https://leetcode.com/problems/number-of-islands/">Number of Islands</a>
 */

public class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    ++count;
                    expand(grid, visited, i, j);
                }
            }
        }
        return count;
    }
    
    public void expand(char[][] grid, boolean[][] visited, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        while (!q.isEmpty()) {
            int[] node = q.remove();
            int ci = node[0], cj = node[1];
            visited[ci][cj] = true;
            if (ci - 1 >= 0 && grid[ci - 1][cj] == '1' && visited[ci - 1][cj] == false) {
                q.add(new int[]{ci - 1, cj});
                visited[ci - 1][cj] = true;
            }
            if (cj + 1 <= grid[0].length - 1 && grid[ci][cj + 1] == '1' && visited[ci][cj + 1] == false) {
                q.add(new int[]{ci, cj + 1});
                visited[ci][cj + 1] = true;
            }
            if (ci + 1 <= grid.length - 1 && grid[ci + 1][cj] == '1' && visited[ci + 1][cj] == false) {
                q.add(new int[]{ci + 1, cj});
                visited[ci + 1][cj] = true;
            }
            if (cj - 1 >= 0 && grid[ci][cj - 1] == '1' && visited[ci][cj - 1] == false) {
                q.add(new int[]{ci, cj - 1});
                visited[ci][cj - 1] = true;
            }
        }
    }
}
