/**
 * @see <a href="https://leetcode.com/problems/candy/">Candy</a>
 */

public class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        int candyArray[] = new int[ratings.length];
        for (int i = 0; i < candyArray.length; ++i) candyArray[i] = 1;
        for (int i = 1; i < candyArray.length; ++i) {
            if (ratings[i] > ratings[i - 1]) candyArray[i] = candyArray[i - 1] + 1;
        }
        for (int i = candyArray.length - 2; i >= 0; --i) {
            if (ratings[i] > ratings[i + 1]) {
                candyArray[i] = Math.max(candyArray[i], candyArray[i + 1] + 1);
            }
        }
        int total = 0;
        for (int i = 0; i < candyArray.length; ++i) {
            total += candyArray[i];
        }
        return total;
    }
}
