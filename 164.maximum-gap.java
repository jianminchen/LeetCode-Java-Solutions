/**
 * @see <a href="https://leetcode.com/problems/maximum-gap/">Maximum Gap</a>
 */

public class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int[] newNums = nums.clone();
        for (int d = 0; d < 10; ++d) {
            newNums = countingSort(newNums, d);
        }
        int max = newNums[1] - newNums[0];
        for (int i = 2; i < newNums.length; ++i) {
            if (max < newNums[i] - newNums[i - 1]) {
                max = newNums[i] - newNums[i - 1];
            }
        }
        return max;
    }
    
    public static int[] countingSort(int[] nums, int i) {
        // sort according to the ith digit. i = 0, 9;

        int[] count = new int[10];
        int[] newNums = new int[nums.length];
        int complete = 1;
        for (int k = 0; k < i; ++k) {
            complete = complete * 10;
        }
        for (int k = 0; k < nums.length; ++k) {
            int which = (nums[k]/complete) % 10;
            ++count[which];
        }
        for (int k = 1; k < count.length; ++k) {
            count[k] = count[k - 1] + count[k];
        }
    	System.out.println();        
        for (int k = nums.length - 1; k >= 0; --k) {
            int which = (nums[k]/complete) % 10;
            newNums[count[which] - 1] = nums[k];
            --count[which];
        }
        nums = newNums;
        return nums;
    }
}
