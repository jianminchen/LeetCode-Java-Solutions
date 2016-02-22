/**
 * @see <a href="https://leetcode.com/problems/search-for-a-range/">Search for a Range</a>
 */

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int low = 0; int high = nums.length - 1;
        int[] res = new int[]{-1, -1};
        while (low <= high) {
            if (target < nums[low] || target > nums[high]) break;
            int mid = low + ((high - low)>>1);
            if (target > nums[mid]) low = mid + 1;
            else if (target == nums[mid]) {
                int leftbound = getLeftBound(nums, target, mid);
                int rightbound = getRightBound(nums,target, mid);
                res[0] = leftbound;
                res[1] = rightbound;
                break;
            }
            else high = mid - 1;
        }
        return res;
    }
    public int getLeftBound(int[] nums, int target, int mid) {
        int low = 0;
        int high = mid;
        while (low <= high) {
            mid = low + ((high - low)>>1);
            if (low == high) break;
            if (nums[mid] == target) high = mid;
            else if (nums[mid] < target) low = mid + 1;
        }
        return low;
    }
    public int getRightBound(int[] nums, int target, int mid) {
        int low = mid; int high = nums.length - 1;
        while (low <= high) {
            mid = low + ((high - low)>>1);
            if (low == high) break;
            if (low == high - 1) {
                if (nums[high] > target) return low;
                else if (nums[high] == target) return high;
            }
            if (nums[mid] == target) low = mid; // can't use low = mid + 1.
            else if (nums[mid] > target) high = mid - 1;
        }
        return high;
    }
}
