/**
 * @see <a href="https://leetcode.com/problems/best-meeting-point/">Best Meeting Point</a>
 */

public class Solution {
    // we need to find the median of the x coordinates, and the median of the y coordinates
    public int minTotalDistance(int[][] grid) {
        if (grid == null) throw new NullPointerException();
        if (grid.length <= 1 && grid[0].length <= 1) return 0;
        ArrayList<int[]> nodes = new ArrayList<int[]>();
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    int[] aNode = new int[]{i, j};
                    nodes.add(aNode);
                }
            }
        }
        int xArray[] = new int[nodes.size()];
        int yArray[] = new int[nodes.size()];
        for (int i = 0; i < xArray.length; ++i) {
            xArray[i] = nodes.get(i)[0]; 
            yArray[i] = nodes.get(i)[1];
        }
        Arrays.sort(xArray);
        Arrays.sort(yArray);
        int x = xArray[xArray.length/2];
        int y = yArray[yArray.length/2];
        int sum = 0;
        for (int i = 0; i < xArray.length; ++i) {
            sum += Math.abs(xArray[i] - x);
            sum += Math.abs(yArray[i] - y);
        }
        return sum;
    }
}
