/**
 * @see <a href="https://leetcode.com/problems/search-in-rotated-sorted-array/">Search in Rotated Sorted Array</a>
 */

// Binary search solution: by comparing nums[mid] to nums[high], we can determine which condition we are in;
// In different conditions, we can further determine which side the target can be by comparing target 
// with nums[mid], nums[low], and nums[high]. We can combine some of the conditions to make the code simple and clean.
public class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1, mid = -1;
        while (true) {
            if (low > high) return -1;
            mid = low + ((high - low) >> 1);
            if (target == nums[mid]) break;
            if ((nums[mid] > nums[high] && target < nums[mid] && target >= nums[low])
                    || (nums[mid] < nums[high] && (target > nums[high] || target < nums[mid]))) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return mid;
    }
}
