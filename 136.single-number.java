/**
 * @see <a href="https://leetcode.com/problems/single-number/">Single Number</a>
 */

public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i ++) {
            res ^= nums[i];
        }
        return res;
    }
}
