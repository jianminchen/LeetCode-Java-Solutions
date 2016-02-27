/**
 * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/">Remove Duplicates from Sorted Array</a>
 */

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int pFill = 0;
        int i = 1; // the first element will not change.
        while (i < nums.length) {
            if (nums[i] == nums[pFill]) {}
            else {
                ++pFill;
                nums[pFill] = nums[i]; 
            }
            ++i;
        }
        return pFill + 1;
    }
}
