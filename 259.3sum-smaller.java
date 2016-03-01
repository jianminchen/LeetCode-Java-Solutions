/**
 * @see <a href="https://leetcode.com/problems/3sum-smaller/">3Sum Smaller</a>
 */

public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i <= nums.length - 3; ++i) {
            for (int j = i + 1; j <= nums.length - 2; ++j) {
                for (int k = j + 1; k <= nums.length - 1; ++k) {
                    if (nums[i] + nums[j] + nums[k] < target) ++count;
                }
            }
        }
        return count;
    }
}
// TODO: reduce time complexity to O(n^2)
