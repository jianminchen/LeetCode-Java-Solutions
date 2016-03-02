/**
 * @see <a href="https://leetcode.com/problems/sort-colors/">Sort Colors</a>
 */

public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null) throw new NullPointerException();
        int nextZero = 0, i = 0;
        for (; i < nums.length; ++i) {
            if (nums[i] == 0) {
                if (i != nextZero) {
                    swap(nums, i, nextZero);
                }
                ++nextZero;
            }
        }
        i = nextZero; // the next index for 1 from now on
        for (; i < nums.length; ++i) {
            if (nums[i] == 1) {
                if (i != nextZero) {
                    swap(nums, i, nextZero);
                }
                ++nextZero;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
