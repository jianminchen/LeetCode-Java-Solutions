/**
 * @see <a href="https://leetcode.com/problems/best-meeting-point/">Best Meeting Point</a>
 */

public class Solution {
    public int minTotalDistance(int[][] grid) {
        // grid are not the (x, y) coordinates!!!!!!!!!!!!!!!!!!!!!!!!!!!
        // grid are just filled with 1s and 0s.
        ArrayList<int[]> nodes = new ArrayList<int[]>();
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {

                // the following has compile error!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                // if (grid[i][j] == 1) nodes.add(new int[2]{i, j});
                // initialization can only used for constants, instead of variables?????????????????
                if (grid[i][j] == 1) {
                    int[] aNode = new int[2];
                    aNode[0] = i;
                    aNode[1] = j;
                    nodes.add(aNode);
                }
                
            }
        }
        // 
        int xArray[] = new int[nodes.size()];
        int yArray[] = new int[nodes.size()];
        for (int i = 0; i < xArray.length; ++i) {
            // the following writting is correct!!!!!!!!!!!!!
            // if nodes.get(i) is an array, we can use this expression.
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
