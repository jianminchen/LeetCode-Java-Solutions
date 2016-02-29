/**
 * @see <a href="https://leetcode.com/problems/maximum-product-subarray/">Maximum Product Subarray</a>
 */

public class Solution {
    // this is a divide and conquer solution.
    // a better solution is using dynamic programming as in maximum sum subarray
    public int maxProduct(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        return maxProd(nums, low, high);        
    }
    
    private int maxProd(int[] nums, int low, int high) {
        if (low == high) return nums[low];
        int mid = low + ((high - low) >> 1);
        int max1 = maxProd(nums, low, mid);
        int max2 = maxProd(nums, mid + 1, high);
        int maxProd1 = nums[mid];
        int minProd1 = nums[mid];
        int prod= nums[mid];
        for (int i = mid - 1; i >= low; --i) {
            prod *= nums[i];
            maxProd1 = Math.max(maxProd1, prod);
            minProd1 = Math.min(minProd1, prod);
        }
        int maxProd2 = nums[mid + 1];
        int minProd2 = nums[mid + 1];
        prod = nums[mid + 1];
        for (int i = mid + 2; i <= high; ++i) {
            prod *= nums[i];
            maxProd2 = Math.max(maxProd2, prod);
            minProd2 = Math.min(minProd2, prod);
        }
        return Math.max(Math.max(Math.max(max1, max2), maxProd2 * maxProd1), minProd1 * minProd2);
    }
}
