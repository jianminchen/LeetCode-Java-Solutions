/**
 * @see <a href="https://leetcode.com/problems/smallest-rectangle-enclosing-black-pixels/">Smallest Rectangle Enclosing Black Pixels</a>
 */

public class Solution {
    public int minArea(char[][] image, int x, int y) {
        int nR = image.length;
        int nC = image[0].length;
        boolean visited[][] = new boolean[nR][nC];
        
        visited[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        int rightMost = x;
        int leftMost = x;
        int upperMost = y;
        int lowerMost = y;
        while (!q.isEmpty()) {
            int[] cur = q.remove();
            for (int[] nb : getNeighbors(cur[0], cur[1], nR, nC)) {
                if (visited[nb[0]][nb[1]] == false && image[nb[0]][nb[1]] == '1') {
                    q.add(new int[]{nb[0], nb[1]});
                    visited[nb[0]][nb[1]] = true;
                    rightMost = Math.max(rightMost, nb[0]);
                    leftMost = Math.min(leftMost, nb[0]);
                    upperMost = Math.max(upperMost, nb[1]);
                    lowerMost = Math.min(lowerMost, nb[1]);
                }
            }
        }
        
        return (rightMost - leftMost + 1) * (upperMost - lowerMost + 1);
    }
    
    public List<int[]> getNeighbors(int i, int j, int r, int c) {
        List<int[]> res = new ArrayList<>();
        if (i - 1 >= 0) res.add(new int[]{i - 1, j});
        if (i + 1 <= r - 1) res.add(new int[]{i + 1, j});
        if (j - 1 >= 0) res.add(new int[]{i, j - 1});
        if (j + 1 <= c - 1) res.add(new int[]{i, j + 1});
        return res;
    }
}
