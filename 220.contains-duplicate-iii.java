/**
 * @see <a href="https://leetcode.com/problems/contains-duplicate-iii/">Contains Duplicate III</a>
 */

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length <= 1 || t < 0) return false;
        if (k <= 0) return false;
        TreeSet<Integer> ts = new TreeSet<Integer>();
        ts.add(nums[0]);
        for (int i = 1; i < nums.length; ++i) {
            if (i - k - 1>= 0) ts.remove(nums[i - k - 1]);
            Integer floor = ts.floor(nums[i]);
            Integer ceil = ts.ceiling(nums[i]);

            if ((floor != null && (nums[i] - floor >= 0 && nums[i] - floor <= t)) 
                    || (ceil != null && (ceil - nums[i] >= 0 && ceil - nums[i] <= t))) {
                return true;
            }
            ts.add(nums[i]);
        }
        return false;
    }
}
