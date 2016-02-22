/**
 * @see <a href="https://leetcode.com/problems/jump-game-ii/">Jump Game II</a>
 */

public class Solution {
    public int jump(int[] nums) {
        int max = 0;
        int minJump[] = new int[nums.length];
        minJump[0] = 0;
        for (int i = 1; i < minJump.length; ++i) {
            minJump[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i <= max && i <= nums.length - 1; ++i) {
            int newMax = Math.max(max, i + nums[i]);
            for (int j = max + 1; j <= Math.min(newMax, nums.length - 1); ++j) {
                minJump[j] = minJump[i] + 1;
            }
            max = newMax;
        }
        return minJump[nums.length - 1];
    }
}
