/**
 * @see <a href="https://leetcode.com/problems/first-missing-positive/">First Missing Positive</a>
 */

public class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null) throw new NullPointerException();
        if (nums.length == 0) return 1;
        for (int i = 0; i < nums.length; ++i) {
            int cur = i;
            int toSwap = nums[i] - 1; // which element needs to be swapped with cur.
            while (toSwap >= 0 && toSwap < nums.length && nums[cur] != nums[toSwap]) {
                swap(nums, cur, toSwap);
                toSwap = nums[i] - 1;
            }
        }
        int i = 0;
        while (i < nums.length && nums[i] == i + 1) ++i;
        return i + 1;
    }
    private void swap(int[] nums, int i, int j) {
        if (i == j) return;
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
