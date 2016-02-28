/**
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">Best Time to Buy and Sell Stock</a>
 */

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null) throw new NullPointerException();
        if (prices.length == 0 || prices.length == 1) return 0;
        int low = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < prices.length; ++i) {
            if (prices[i] >= low) {
                maxProfit = Math.max(maxProfit, prices[i] - low);
            } else { // prices[i] < low
                low = prices[i];
            }
        }
        return maxProfit;
    }
}
