/**
 * @see <a href="https://leetcode.com/problems/search-insert-position/">Search Insert Position</a>
 */

public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null) throw new NullPointerException();
        if (nums.length == 0) return 0;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            if (target < nums[low]) return low;
            if (target > nums[high]) return high + 1;
            int mid = low + ((high - low) >> 1);
            
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {// target < nums[mid]
                high = mid - 1;
            }
        }
        return -1;
    }
}
