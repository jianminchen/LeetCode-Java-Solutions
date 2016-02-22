/**
 * @see <a href="https://leetcode.com/problems/search-in-rotated-sorted-array-ii/">Search in Rotated Sorted Array II</a>
 */

public class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (true) {
            if (low > high) return false;
            int mid = low + ((high - low)>>1);
            if (target == nums[low]) return true;
            if (target == nums[high]) return true;
            if (target == nums[mid]) return true;
            
            if (nums[mid] > nums[high]) {
                if (target > nums[mid]) {
                    low = mid + 1;
                }
                else {
                    // target < nums[mid]
                    ++low;
                    --high;
                }
            }
            else if (nums[mid] < nums[low]) {
                if (target < nums[mid]) {
                    high = mid - 1;
                }
                else { // target > nums[mid]
                    --high;
                    ++low;
                }
            }
            else {
                ++low;
                --high;
            }
        }
    }
}
