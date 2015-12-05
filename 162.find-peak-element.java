/**
 * @see <a href="https://leetcode.com/problems/find-peak-element/">Find Peak Element</a>
 */

public class Solution {
    public int findPeakElement(int[] nums) {
        // findPeakElement(int[] nums, int low, int high);
        // can find the peak given nums[low - 1] < nums[low],
        // nums[high] > nums[high + 1].
        if (nums.length == 0) return -1;
        return findPeakElement(nums, 0, nums.length - 1);
    }
    public int findPeakElement(int[] nums, int low, int high) {
        // previously written as return nums[low], wrong !!!!!!!!!!!
        // we should return the index, not the number.
        if (low == high) return low;
        if (low == high - 1) {
            return nums[low] > nums[high] ? low : high;
        }
        int mid = low + ((high - low)>>1);
        if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;
        else if (nums[mid] < nums[mid - 1]) {
            return findPeakElement(nums, low, mid - 1);
        }
        else { // nums[mid] < nums[mid + 1];
            return findPeakElement(nums, mid + 1, high);
        }
    }
}
