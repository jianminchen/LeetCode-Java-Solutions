public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null) throw new NullPointerException();
        if (prices.length <= 1) return 0;
        int n = prices.length;
        if (k >= n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; ++i) {
                if (prices[i] > prices[i - 1]) maxProfit += prices[i] - prices[i - 1];
            }
            return maxProfit;
        }
        
        int[][] profit = new int[k + 1][prices.length];
        // profit i, j is the maxprofit can be obtained by conducting i transactions up to prices[j];
        // profit[0][j] = 0; profit[i][0] = 0;
        for (int i = 1; i <= k; ++i) {
            int locMax = profit[i - 1][0] - prices[0];
            for (int j = 1; j < n; ++j) {
                profit[i][j] = Math.max(profit[i][j - 1], prices[j] + locMax);
                locMax = Math.max(locMax, profit[i - 1][j] - prices[j]);
            }
        }
        return profit[k][n - 1];
    }
}
