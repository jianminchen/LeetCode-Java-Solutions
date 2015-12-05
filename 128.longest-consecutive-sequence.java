/**
 * @see <a href="https://leetcode.com/problems/longest-consecutive-sequence/">Longest Consecutive Sequence</a>
 */

public class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int max = 0;
        while (i < nums.length) {
            int start = i;
            ++i;
            int len = 1;
            while (i < nums.length && (nums[i] == nums[i - 1] + 1 || nums[i] == nums[i - 1])) {
                if (nums[i] == nums[i - 1]) ;
                else ++len;
                ++i;
            }
            int end = i;
            max = Math.max(max, len);
        }
        return max;
    }
}
