/**
 * @see <a href="https://leetcode.com/problems/product-of-array-except-self/">Product of Array Except Self</a>
 */

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int res[] = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; ++i) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int prev = 1;
        
        for (int i = nums.length - 1; i >= 0; --i) {
            int nextPrev = prev * nums[i];
            res[i] = prev *  res[i];
            prev = nextPrev;
        }
        return res;
    }
}
