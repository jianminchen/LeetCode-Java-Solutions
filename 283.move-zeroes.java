/**
 * @see <a href="https://leetcode.com/problems/move-zeroes/">Move Zeroes</a>
 */

public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null) throw new NullPointerException();
        int pZero = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                nums[pZero] = nums[j];
                if (j != pZero) nums[j] = 0;
                ++j;
                ++pZero;
            } else {
                ++j;
            }
        }
    }
}
