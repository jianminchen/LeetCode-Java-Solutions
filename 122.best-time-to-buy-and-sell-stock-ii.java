/**
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/">Best Time to Buy and Sell Stock II</a>
 */

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null) throw new NullPointerException();
        int max = 0;
        for (int i = 0; i + 1 < prices.length; ++i) {
            if (prices[i + 1] > prices[i]) {
                max += prices[i + 1] - prices[i];
            }
        }
        return max;
    }
}
