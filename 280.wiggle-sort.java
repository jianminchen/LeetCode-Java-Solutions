/**
 * @see <a href="https://leetcode.com/problems/wiggle-sort/">Wiggle Sort</a>
 */

public class Solution {
    public void wiggleSort(int[] nums) {
        int i = 0;
        while (i + 1 < nums.length) {
            if (i % 2 == 0) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            } else {
                if (nums[i] < nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }
            ++i;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i]^nums[j];
        nums[j] = nums[i]^nums[j];
        nums[i] = nums[i]^nums[j];
    }
}
