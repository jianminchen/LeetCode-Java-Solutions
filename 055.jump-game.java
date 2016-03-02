/**
 * @see <a href="https://leetcode.com/problems/jump-game/">Jump Game</a>
 */

public class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null) throw new NullPointerException();
        int max = 0;
        for (int i = 0; i <= max && i <= nums.length - 1; ++i) {
            max = Math.max(max, i + nums[i]);
        }
        if (max < nums.length - 1) return false;
        else return true;
    }
}
