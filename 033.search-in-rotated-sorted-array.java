/**
 * @see <a href="https://leetcode.com/problems/search-in-rotated-sorted-array/">Search in Rotated Sorted Array</a>
 */

public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int low = 0; int high = nums.length - 1;
        while (true) {
            if (low == high) {
                if (target == nums[low]) return low;
                else return -1;
            }
            if (low == high - 1) {
                if (target == nums[low]) return low;
                else if (target == nums[high]) return high;
                else return -1;
            }
            int mid = low + ((high - low) >> 1);
            
            if (target > nums[low]) {
                // the first part.
                if (nums[mid] > nums[low]) {
                    if (target < nums[mid]) high = mid -1;
                    else if (target == nums[mid]) return mid;
                    else low = mid + 1;
                } else {// since mid != low, we have nums[mid] != nums[low]
                    // nums[mid] < nums[low]
                    high = mid - 1;
                }
            } else if (target == nums[low]) {
                return low;
            } else {
                // target < nums[low], the second part ? 
                if (nums[mid] > nums[low]) {
                    low = mid + 1;
                } else {
                    // nums[mid] < nums[low]
                    if (target > nums[mid]) low = mid + 1;
                    else if (target == nums[mid]) return mid;
                    else high = mid - 1;
                }
            }
        }
    }
}
