/**
 * @see <a href="https://leetcode.com/problems/walls-and-gates/">Walls and Gates</a>
 */

public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) return;
        Queue<int[]> q = new LinkedList<>();
        
        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
        
        for (int i = 0; i < rooms.length; ++i) {
            for (int j = 0; j < rooms[0].length; ++j) {
                if (rooms[i][j] == 0) {
                    int[] zeroLoc = new int[]{i, j};
                    q.add(zeroLoc);
                    visited[i][j] = true;
                }
            }
        }
        // boolean[][] visited = new boolean[rooms.length][rooms[0].length];
        // first time, label zeros as visited !!!!!!!!!!!
        // do not label when it is removed, because if labeling only when removed, other zeros will not be labeled.
        // the logic will be wrong.
        /*
        while (!q.isEmpty()) {
            int[] zLoc = q.remove();
            int i = zLoc[0], j = zLoc[1];
            visited[i][j] = true;
            if (i - 1 >= 0 && visited[i - 1][j] == false && rooms[i - 1][j] != -1) {
                q.add(new int[]{i - 1, j});
                rooms[i - 1][j] = Math.min(rooms[i][j] + 1, rooms[i - 1][j]);
            }
            if (j + 1 <= rooms[0].length - 1 && visited[i][j + 1] == false && rooms[i][j + 1] != -1) {
                q.add(new int[]{i, j + 1});
                rooms[i][j + 1] = Math.min(rooms[i][j] + 1, rooms[i][j + 1]);
            }
            if (i + 1 <= rooms.length - 1 && visited[i + 1][j] == false && rooms[i + 1][j] != -1) {
                q.add(new int[]{i + 1, j});
                rooms[i + 1][j] = Math.min(rooms[i][j] + 1, rooms[i + 1][j]);
            }
            if (j - 1 >= 0 && visited[i][j - 1] == false && rooms[i][j - 1] != -1) {
                q.add(new int[]{i, j - 1});
                rooms[i][j - 1] =  Math.min(rooms[i][j] + 1, rooms[i][j - 1]);
            }
        }
        */ // use function to deal with the four cases.
        /*
        while (!q.isEmpty()) {
            int[] zLoc = q.remove();
            int i = zLoc[0], j = zLoc[1];
            // visited[i][j] = true;
            if (i - 1 >= 0 && visited[i - 1][j] == false && rooms[i - 1][j] != -1) {
                q.add(new int[]{i - 1, j});
                rooms[i - 1][j] = rooms[i][j] + 1;
                visited[i - 1][j] = true;
            }
            if (j + 1 <= rooms[0].length - 1 && visited[i][j + 1] == false && rooms[i][j + 1] != -1) {
                q.add(new int[]{i, j + 1});
                rooms[i][j + 1] = rooms[i][j] + 1;
                visited[i][j + 1] = true;
            }
            if (i + 1 <= rooms.length - 1 && visited[i + 1][j] == false && rooms[i + 1][j] != -1) {
                q.add(new int[]{i + 1, j});
                rooms[i + 1][j] = rooms[i][j] + 1;
                visited[i + 1][j] = true;
            }
            if (j - 1 >= 0 && visited[i][j - 1] == false && rooms[i][j - 1] != -1) {
                q.add(new int[]{i, j - 1});
                rooms[i][j - 1] =  rooms[i][j] + 1;
                visited[i][j - 1] = true;
            }
        } */
        while (!q.isEmpty()) {
            int[] zLoc = q.remove();
            int i = zLoc[0], j = zLoc[1];
            // visited[i][j] = true;
            if (i - 1 >= 0 && rooms[i - 1][j] == Integer.MAX_VALUE) {
                q.add(new int[]{i - 1, j});
                rooms[i - 1][j] = rooms[i][j] + 1;
                // visited[i - 1][j] = true;
            }
            if (j + 1 <= rooms[0].length - 1 && rooms[i][j + 1] == Integer.MAX_VALUE) {
                q.add(new int[]{i, j + 1});
                rooms[i][j + 1] = rooms[i][j] + 1;
                // visited[i][j + 1] = true;
            }
            if (i + 1 <= rooms.length - 1 && rooms[i + 1][j] == Integer.MAX_VALUE) {
                q.add(new int[]{i + 1, j});
                rooms[i + 1][j] = rooms[i][j] + 1;
                // visited[i + 1][j] = true;
            }
            if (j - 1 >= 0 && rooms[i][j - 1] == Integer.MAX_VALUE) {
                q.add(new int[]{i, j - 1});
                rooms[i][j - 1] =  rooms[i][j] + 1;
                // visited[i][j - 1] = true;
            }
        }
        
    }
}
