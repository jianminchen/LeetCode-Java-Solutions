/**
 * @see <a href="https://leetcode.com/problems/rotate-array/">Rotate Array</a>
 */

public class Solution {
    public void rotate(int[] nums, int k) {
        /* the following solution has time limit exceeded.
        int kRight = k % nums.length;
        int kLeft = nums.length - kRight;
        if (kRight < kLeft) {
            for (int i = 0; i < kRight; i ++) {
                int temp = nums[nums.length - 1];
                for(int j = nums.length - 2; j >= 0; j --) {
                    nums[j + 1] = nums[j];
                }
                nums[0] = temp;
            }
        }
        else {
            for (int i = 0; i < kLeft; i ++) {
                int temp = nums[0];
                for(int j = 0; j <= nums.length - 2; j++) {
                    nums[j] = nums[j+1];
                }
                nums[nums.length - 1] = temp;
            } 
        }
        */
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
