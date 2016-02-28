/**
 * @see <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/">Find Minimum in Rotated Sorted Array</a>
 */

public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return Integer.MIN_VALUE;
        // an iterative binary search is better, be aware of the stack memory usage for recursive methods.
        return findMin(nums, 0, nums.length - 1); 
    }
    private int findMin(int[] nums, int low, int high) {
        if (low == high) return nums[low];
        int mid = low + ((high - low) >> 1);
        if (nums[mid] > nums[high]) {
            return findMin(nums, mid + 1, high);
        } else if (nums[mid] < nums[high]) {
            return findMin(nums, low, mid);
        }
        return Integer.MIN_VALUE;
    }
}
// test cases: 
// []
// [0]
// [0, 1]
// [1, 0]
// [0, 1, 2, 3, 4]
// [3, 4, 0, 1, 2]
