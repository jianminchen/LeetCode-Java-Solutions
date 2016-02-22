/**
 * @see <a href="https://leetcode.com/problems/walls-and-gates/">Walls and Gates</a>
 */

public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) return;
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < rooms.length; ++i) {
            for (int j = 0; j < rooms[0].length; ++j) {
                if (rooms[i][j] == 0) {
                    int[] zeroLoc = new int[]{i, j};
                    q.add(zeroLoc);
                }
            }
        }

        while (!q.isEmpty()) {
            int[] zLoc = q.remove();
            int i = zLoc[0], j = zLoc[1];
            if (i - 1 >= 0 && rooms[i - 1][j] == Integer.MAX_VALUE) {
                q.add(new int[]{i - 1, j});
                rooms[i - 1][j] = rooms[i][j] + 1;
            }
            if (j + 1 <= rooms[0].length - 1 && rooms[i][j + 1] == Integer.MAX_VALUE) {
                q.add(new int[]{i, j + 1});
                rooms[i][j + 1] = rooms[i][j] + 1;
            }
            if (i + 1 <= rooms.length - 1 && rooms[i + 1][j] == Integer.MAX_VALUE) {
                q.add(new int[]{i + 1, j});
                rooms[i + 1][j] = rooms[i][j] + 1;
            }
            if (j - 1 >= 0 && rooms[i][j - 1] == Integer.MAX_VALUE) {
                q.add(new int[]{i, j - 1});
                rooms[i][j - 1] =  rooms[i][j] + 1;
            }
        }
        
    }
}
