/**
 * @see <a href="https://leetcode.com/problems/search-in-rotated-sorted-array-ii/">Search in Rotated Sorted Array II</a>
 */

public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null) throw new NullPointerException();
        int low = 0, high = nums.length - 1;
        while (true) {
            if (low > high) return false;
            int mid = low + ((high - low) >> 1);
            if (target == nums[low] || target == nums[mid] || target == nums[high]) return true;

            if (nums[mid] > nums[high] && target > nums[mid]) {
                low = mid + 1;
            } else if (nums[mid] < nums[low] && target < nums[mid]) {
                high = mid - 1;
            } else {
                ++low;
                --high;
            }
        }
    }
}
