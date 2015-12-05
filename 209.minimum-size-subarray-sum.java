/**
 * @see <a href="https://leetcode.com/problems/minimum-size-subarray-sum/">Minimum Size Subarray Sum</a>
 */

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        //int sum = nums[0];
        //for (int i = 1; i < nums.length - 1; ++i) {
        //    sum += nums[i];
        //}
        //if (sum < s) return 0;
        
        int i = 0, j = 0;
        int sum = nums[0];
        int minLen = nums.length + 1;
        
        while (true) {
            if (sum < s) {
                ++j;
                if (j == nums.length) break;
                sum += nums[j];
            }
            else { // sum >= s
                minLen = Math.min(minLen, j - i + 1);
                sum -= nums[i];
                ++i;
            }
        }
        
/*
        
        while (true) {
            while (j < nums.length && sum < s) {
                ++j;
                if (j == nums.length) break;
                sum += nums[j];
            }
            if (j == nums.length) break;
            // minLen = Math.min(minLen, j - i + 1);
            while (sum >= s) {
                minLen = Math.min(minLen, j - i + 1);
                sum -= nums[i];
                ++i;
            }
            // minLen = Math.min(minLen, j - i);            
        }
  */      
        if (minLen > nums.length) return 0;
        return minLen;
    }
}
