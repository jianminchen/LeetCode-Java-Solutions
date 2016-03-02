/**
 * @see <a href="https://leetcode.com/problems/3sum-closest/">3Sum Closest</a>
 */

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null) throw new NullPointerException();
        int minDistance = Integer.MAX_VALUE;
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ++i) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - target) < minDistance) {
                    minDistance = Math.abs(sum - target);
                    res = sum;
                    if (minDistance == 0) break;
                }
                if (sum > target) {
                    --k;
                } else {
                    ++j;
                }
            }
        }
        return res;
    }
}
