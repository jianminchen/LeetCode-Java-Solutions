/**
 * @see <a href="https://leetcode.com/problems/walls-and-gates/">Walls and Gates</a>
 */

public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null) throw new NullPointerException();
        if (rooms.length == 0 || rooms[0].length == 0) return;
        Queue<int[]> q = new LinkedList<>();
        int row = rooms.length, col = rooms[0].length;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (rooms[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }
        
        // use some variables can help to write clean code!
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty()) {
            int[] zLoc = q.remove();
            int i = zLoc[0], j = zLoc[1];
            for (int[] d : dir) { // basically, check the neighbors of the current position
                if (i + d[0] >= 0 && i + d[0] < row && j + d[1] >= 0 && j + d[1] < col
                        && rooms[i + d[0]][j + d[1]] == Integer.MAX_VALUE) {
                    q.add(new int[]{i + d[0], j + d[1]});
                    rooms[i + d[0]][j + d[1]] = rooms[i][j] + 1;
                }
            }
        }
    }
}
