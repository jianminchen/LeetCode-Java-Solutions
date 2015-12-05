/**
 * @see <a href="https://leetcode.com/problems/sort-colors/">Sort Colors</a>
 */

public class Solution {
    public void sortColors(int[] nums) {
        int nextZero = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 0) {
                if (i == nextZero) ;
                else {
                    swap(nums, i, nextZero);
                }
                ++nextZero;
            }
            ++i;
        }
        i = nextZero; // the next index for 1 from new on.
        while (i < nums.length) {
            if (nums[i] == 1) {
                if (i == nextZero) ;
                else {
                    swap(nums, i, nextZero);
                }
                ++nextZero;
            }
            ++i;
        }
    }
    public void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
