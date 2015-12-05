/**
 * @see <a href="https://leetcode.com/problems/paint-house-ii/">Paint House II</a>
 */

public class Solution {
    public int minCostII(int[][] costs) {
        // array index out of bound for the following line:
        // int[] minCost = new int[costs[0].length];
        // need to check array length zero or not !!!!!!!!!!!!
        if (costs.length == 0 || costs[0].length == 0) return 0;
        int[] minCost = new int[costs[0].length];
        for (int k = 0; k < costs[0].length; ++k) {
            minCost[k] = costs[0][k];
        }
        // minCost[k] is the min cost of painting previous houses that ends with color k.
        for (int i = 1; i < costs.length; ++i) {
            int newMinCost[] = new int[costs[0].length];
            for (int k = 0; k < costs[0].length; ++k) {
                newMinCost[k] = Integer.MAX_VALUE;
                for (int kk = 0; kk < costs[0].length; ++kk) {
                    if (kk != k) {
                        newMinCost[k] = Math.min(minCost[kk] + costs[i][k], newMinCost[k]);
                    }
                }
            }
            minCost = newMinCost;
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < minCost.length; ++i) {
            if (min > minCost[i]) min = minCost[i];
        }
        return min;
    }
}
