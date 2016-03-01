/**
 * @see <a href="https://leetcode.com/problems/longest-increasing-subsequence/">Longest Increasing Subsequence</a>
 */

public class Solution {
    // dynamic programming solution
    public int lengthOfLIS(int[] nums) {
        if (nums == null) throw new NullPointerException();
        if (nums.length <= 1) return nums.length;
        
        // maxLen[i] will be the max len of a subsequence that start at i.
        int maxLen[] = new int[nums.length];
        for (int i = 0; i < maxLen.length; ++i) {
            maxLen[i] = 1;
        }
        int max = maxLen[0];
        for (int i = maxLen.length - 2; i >= 0; --i) {
            for (int j = i + 1; j < maxLen.length; ++j) {
                if (nums[i] < nums[j]) {
                    maxLen[i] = Math.max(maxLen[i], 1 + maxLen[j]);
                }
            }
            if (max < maxLen[i]) max = maxLen[i];
        }
        return max;
    }
}
