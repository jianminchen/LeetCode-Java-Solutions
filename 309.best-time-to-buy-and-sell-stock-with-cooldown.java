/**
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/">Best Time to Buy and Sell Stock with Cooldown</a>
 */

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null) throw new NullPointerException();
        if (prices.length == 0) return 0;
        int[] np = new int[prices.length + 2];
        np[0] = prices[0];
        np[1] = prices[0];
        for (int i = 2; i < np.length; ++i) {
            np[i] = prices[i - 2];
        }
        int prevM = 0; // actually, did not use it.
        int prev = 2;
        int i = 3;
        int maxP[] = new int[np.length];
        while (i < np.length) {
            if (np[i] > np[i - 1]) {
                maxP[i] = Math.max(maxP[prev - 1] + np[i] - np[prev + 1], maxP[prev - 2] + np[i] - np[prev]);
                maxP[i] = Math.max(maxP[i], maxP[prev - 1] + np[i] - np[prev - 1]);
            } else {
                prev = i;
                maxP[i] = maxP[i - 1];
            }
            ++i;
        }
        return maxP[np.length - 1];
    }
}
