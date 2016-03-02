/**
 * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/">Remove Duplicates from Sorted Array</a>
 */

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) throw new NullPointerException();
        if (nums.length == 0 || nums.length == 1) return nums.length;
        int pFill = 0, i = 1; // the first element will not change.
        while (i < nums.length) {
            if (nums[i] != nums[pFill]) {
                ++pFill;
                nums[pFill] = nums[i]; 
            }
            ++i;
        }
        return pFill + 1;
    }
}
