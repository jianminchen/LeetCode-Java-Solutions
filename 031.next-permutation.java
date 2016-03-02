/**
 * @see <a href="https://leetcode.com/problems/next-permutation/">Next Permutation</a>
 */

public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null) throw new NullPointerException();
        if (nums.length == 0 || nums.length == 1) return;
        int i = nums.length - 1;
        while (i - 1 >= 0 && nums[i - 1] >= nums[i]) {
            --i;
        }
        if (i == 0) {
            for (int j = 0; j < nums.length / 2; ++j) {
                swap(nums, j, nums.length - 1 - j);
            }
        } else {
            int j = nums.length - 1;
            for (; ; --j) {
                if (nums[j] > nums[i - 1]) break;
            }
            swap(nums, i - 1, j);
            Arrays.sort(nums, i, nums.length);
        }
    }
    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
