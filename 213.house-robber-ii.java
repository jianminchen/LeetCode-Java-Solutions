/**
 * @see <a href="https://leetcode.com/problems/house-robber-ii/">House Robber II</a>
 */

public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(nums[0] + rob(nums, 2, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
    public int rob(int[] nums, int from, int to) {
        // previously written as from < to, causing the java.lang.ArrayIndexOutOfBoundsException.
        if (from > to) return 0;
        if (from == to) return nums[from];
        if (from == to - 1) return Math.max(nums[from], nums[to]);
        int[] max = new int[to - from + 1]; // max[i] is the max value that can be robbed from "from", to "from + i";
        // java.lang.ArrayIndexOutOfBoundsException: 0 ????????????????????????
        max[0] = nums[from];
        max[1] = Math.max(nums[from], nums[from + 1]);
        for (int i = 2; i < to - from + 1; ++i) {
            // previously, written as 
            // max[i] = Math.max(max[i - 2] + nums[i], max[i - 1]);
            // wrong answer !!!!!!!! we are not considering nums[i], we are considering nums[from + i]!!!!
            max[i] = Math.max(max[i - 2] + nums[from + i], max[i - 1]);
        }
        return max[to - from];
    }
}
