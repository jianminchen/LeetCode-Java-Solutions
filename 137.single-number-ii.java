/**
 * @see <a href="https://leetcode.com/problems/single-number-ii/">Single Number II</a>
 */

public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            int ithBit = 0;
            for (int j = 0; j < nums.length; ++j) {
                ithBit += (nums[j]>>i) & 1;
            }
            // after this operation, ithBit must be 0 or 1, can't be 2
            ithBit = ithBit % 3;
            res |= (ithBit << i);
        }
        return res;
    }
}
