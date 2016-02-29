/**
 * @see <a href="https://leetcode.com/problems/missing-number/">Missing Number</a>
 */

public class Solution {
    public int missingNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length + 1; ++i) {
            res ^= i;
        }
        for (int i = 0; i < nums.length ; ++i) {
            res ^= nums[i];
        }
        return res;
    }
}
