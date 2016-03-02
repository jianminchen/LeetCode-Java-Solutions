/**
 * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/">Remove Duplicates from Sorted Array II</a>
 */

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) throw new NullPointerException();
        if (nums.length <= 2) return nums.length;
        int i = 0; // traverse index
        int ri = 0;
        while (i < nums.length) {
            int start = i;
            ++i;
            while (i < nums.length && nums[i] == nums[i - 1]) {
                ++i;
            }
            int count = i - start; // the number of same values.
            
            if (count >= 2) {
                nums[ri] = nums[i - 1];
                nums[ri + 1] = nums[i - 1];
                ri += 2;
            } else {
                nums[ri] = nums[i - 1];
                ri += 1;
            }
        }
        return ri;
    }
}
