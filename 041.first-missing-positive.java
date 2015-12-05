/**
 * @see <a href="https://leetcode.com/problems/first-missing-positive/">First Missing Positive</a>
 */

public class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) return 1;
        for (int i = 0; i < nums.length; ++i) {
            int cur = i;
            int toSwap = nums[i] - 1; // which element needs to be swapped with cur.
            while (toSwap >= 0 && toSwap < nums.length && nums[cur] != nums[toSwap]) {
                swap(nums, cur, toSwap);
                toSwap = nums[i] - 1;
            }
        }

        for (int i = 0; i < nums.length; ++i) {
            System.out.print(nums[i] + " ");
        }
        
        int i = 0;
        while (i < nums.length && nums[i] == i + 1) ++i;
        // return i is wrong!!!!
        return i + 1;
    }
    // don't forget return type!!!!
    private void swap(int[] nums, int i, int j) {
        // this way of swapping has problem when i == j !!!!!!!!
        // need to consider the case of i = j separately.
        if (i == j) return;
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
