/**
 * @see <a href="https://leetcode.com/problems/single-number-iii/">Single Number III</a>
 */

public class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; ++i) {
            xor ^= nums[i];
        }
        int i = 0;
        while (true) {
            if ((xor & 1) == 1) break;
            else {
                xor = xor >> 1;
                ++i;
            }
        }
        int res[] = new int[2];
        res[0] = 0;
        res[1] = 0;
        for (int j = 0; j < nums.length; ++j) {
            if (((nums[j] >> i) & 1) == 1) {
                res[0] ^= nums[j];
            }
            else {
                res[1] ^= nums[j];
            }
        }
        return res;
    }
}
