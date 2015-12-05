/**
 * @see <a href="https://leetcode.com/problems/paint-house/">Paint House</a>
 */

public class Solution {
    public int minCost(int[][] costs) {
        // to calculate the mininmum cost of i,
        // calculate the minimum cost if i - 1, and record the last used color.
        // the above logic is too simple, and wrong.
        // the following seems correct:
        // each time, need to keep three min values,
        // the min cost of painting i - 1 posts, and ends with color 0.
        // the min cost of painting i - 1 posts, and ends with color 1.
        // the min cost of painting i - 1 posts, and ends with colar 2.
        // the result will be calculated based on these three min values.
        if (costs.length == 0) return 0;
        int min1 = costs[0][0];
        int min2 = costs[0][1];
        int min3 = costs[0][2];
        
        for (int i = 1; i < costs.length; i ++) {
            int newMin1 = Math.min(min2, min3) + costs[i][0];
            int newMin2 = Math.min(min1, min3) + costs[i][1];
            int newMin3 = Math.min(min1, min2) + costs[i][2];
            min1 = newMin1;
            min2 = newMin2;
            min3 = newMin3;
        }
        return Math.min(Math.min(min1, min2), min3);
    }
}
