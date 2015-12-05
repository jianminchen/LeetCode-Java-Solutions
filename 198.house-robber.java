/**
 * @see <a href="https://leetcode.com/problems/house-robber/">House Robber</a>
 */

public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        // in the following cases, we have nums.length >= 3
        int max1 = nums[0];
        int max2 = Math.max(nums[0], nums[1]);
        int maxCur = 0;
        for (int i = 2; i < nums.length; i ++) {
            maxCur = Math.max(max1 + nums[i], max2);
            max1 = max2;
            max2 = maxCur;
        }
        return maxCur;
    }
}
