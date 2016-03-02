/**
 * @see <a href="https://leetcode.com/problems/maximum-subarray/">Maximum Subarray</a>
 */

// this is the divide and conquer solution, which is not the best solution.
// the best solution is the dynamic programming with constant memory consumption.
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null) throw new NullPointerException();
        int low = 0;
        int high = nums.length - 1;
        return maxSum(nums, low, high);
    }
    private int maxSum(int[] nums, int low, int high) {
        if (low == high) return nums[low];
        int mid = low + ((high - low) >> 1);
        int max1 = maxSum(nums, low, mid);
        int max2 = maxSum(nums, mid + 1, high);
        int maxSum1 = nums[mid];
        int sum = nums[mid];
        for (int i = mid - 1; i >= low; --i) {
            sum += nums[i];
            maxSum1 = Math.max(maxSum1, sum);
        }
        int maxSum2 = nums[mid + 1];
        sum = nums[mid + 1];
        for (int i = mid + 2; i <= high; ++i) {
            sum += nums[i];
            maxSum2= Math.max(maxSum2, sum);
        }
        return Math.max(Math.max(max1, max2), maxSum1 + maxSum2);
    }
}
