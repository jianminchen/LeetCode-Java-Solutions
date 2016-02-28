/**
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/">Best Time to Buy and Sell Stock III</a>
 */

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null) throw new NullPointerException();
        if (prices.length <= 1) return 0;
        // forward, get max profit from day 0 up to day i.
        int maxP1[] = new int[prices.length];
        int min = prices[0];
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] < min) min = prices[i];
            maxP1[i] = Math.max(maxP1[i - 1], prices[i] - min);
        }
        // backward, get max profit from day prices.length - 1 down to day i
        int maxP2[] = new int[prices.length];
        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; --i) {
            if (prices[i] > max) max = prices[i];
            maxP2[i] = Math.max(maxP2[i + 1], max - prices[i]);
        }
        int result = 0;
        for (int i = 0; i < prices.length; ++i) {
            if (result < maxP1[i] + maxP2[i]) result = maxP1[i] + maxP2[i];
        }
        return result;
    }
}
