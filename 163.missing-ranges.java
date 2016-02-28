/**
 * @see <a href="https://leetcode.com/problems/missing-ranges/">Missing Ranges</a>
 */

public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            res.add(getRange(lower, upper));
            return res;
        }
        if (lower < nums[0]) {
            res.add(getRange(lower, nums[0] - 1));
        }
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[i - 1] + 1) {
                res.add(getRange(nums[i - 1] + 1, nums[i] - 1));
            }
        }
        if (upper > nums[nums.length - 1]) {
            res.add(getRange(nums[nums.length - 1] + 1, upper));
        }
        return res;
    }
    
    public String getRange(int lower, int upper) {
        StringBuilder sb = new StringBuilder();
        sb.append(lower);
        if (upper == lower) {
            return new String(sb);
        } else {
            sb.append("->");
            sb.append(upper);
            return new String(sb);
        }
        
    }
}
