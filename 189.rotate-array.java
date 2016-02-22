/**
 * @see <a href="https://leetcode.com/problems/rotate-array/">Rotate Array</a>
 */

public class Solution {
    public void rotate(int[] nums, int k) {

        k = k % nums.length;
        int secondHalf[] = new int[k];
        int n = nums.length;
        for (int j = 0; j < k; j ++) {
            secondHalf[k - 1- j] = nums[n - 1 -j]; 
        }
        // move
        for (int j = 0; j < n - k; j ++) {
            nums[n - 1 -j] = nums[n - 1 -j - k];
        }
        for (int j = 0; j < k; j ++) {
            nums[j] = secondHalf[j];
        }
    }
}
