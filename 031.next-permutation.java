/**
 * @see <a href="https://leetcode.com/problems/next-permutation/">Next Permutation</a>
 */

public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return;
        int i = nums.length - 1;
        while (i - 1 >= 0 && nums[i - 1] >= nums[i]) {
            --i;
        }
        if (i == 0) {
            for (int j = 0; j < nums.length / 2; ++j) {
                swap(nums, j, nums.length - 1 - j);
            }
        }
        else {
            // wrong logic. need to swap i - 1 with a number that is the closest to it and greater than it.
            // swap(nums, i - 1, nums.length - 1);
            int j = nums.length - 1;
            for (; ; --j) {
                if (nums[j] > nums[i - 1]) break;
            }
            swap(nums, i - 1, j);
            Arrays.sort(nums, i, nums.length);
        }
    }
    public void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
