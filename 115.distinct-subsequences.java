/**
 * @see <a href="https://leetcode.com/problems/distinct-subsequences/">Distinct Subsequences</a>
 */

public class Solution {
    public int numDistinct(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int[][] nums = new int[sLen + 1][tLen + 1];
        // let nums[i][j] be the number of t.substring(0,j) in s.substring(0, i)
        for (int i = 0; i < sLen; ++i) nums[i][0] = 1;
        for (int j = 1; j < tLen + 1; ++j) {
            int i = 1;            
            while (i < sLen + 1) {
                if (s.charAt(i - 1) != t.charAt(j - 1)) { // cannot use this char.
                    nums[i][j] = nums[i - 1][j];
                } else { // equals; we can either use this char, or not.
                    nums[i][j] = nums[i - 1][j] + nums[i - 1][j - 1];
                }
                ++i;
            }
        }
        return nums[sLen][tLen];
    }
}
