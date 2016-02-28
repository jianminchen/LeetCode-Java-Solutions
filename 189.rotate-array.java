/**
 * @see <a href="https://leetcode.com/problems/rotate-array/">Rotate Array</a>
 */
 
public class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null) throw new NullPointerException();
        if (k < 0) throw new IllegalArgumentException();
        k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }
    
    private void reverse(int[] nums, int si, int ei) {
        if (si >= ei) return;
        for (int i = 0; i < (ei - si + 1) >> 1; ++i) {
            nums[si + i] = nums[si + i] ^ nums[ei - i];
            nums[ei - i] = nums[si + i] ^ nums[ei - i];
            nums[si + i] = nums[si + i] ^ nums[ei - i];
        }
    }
}
