/**
 * @see <a href="https://leetcode.com/problems/summary-ranges/">Summary Ranges</a>
 */

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if (nums == null || nums.length == 0) return res;
        int i = 0;
        while (i < nums.length) {
            int start = i;
            while (i + 1 < nums.length && nums[i] == nums[i + 1] - 1) {
                ++i;
            }
            int end = i;
            String s = (new Integer(nums[start])).toString();
            if (end != start) {
                s = s + "->";
                s = s + (new Integer(nums[end])).toString();
            }
            res.add(s);
            ++i;
        }
        return res;
    }
}
