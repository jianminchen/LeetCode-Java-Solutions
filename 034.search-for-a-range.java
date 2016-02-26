/**
 * @see <a href="https://leetcode.com/problems/search-for-a-range/">Search for a Range</a>
 */

public class Solution {
  public int[] searchRange(int[] nums, int target) {
    if (nums == null) {
      throw new NullPointerException();
    }
    int low = 0, high = nums.length - 1;
    int[] res = {-1, -1};
    while (low <= high) {
      if (target < nums[low] || target > nums[high]) {
        break;
      }
      	int mid = low + ((high - low) >> 1);
      if (target > nums[mid]) {
        low = mid + 1;
      } else if (target == nums[mid]) {
        res[0] = getLeftBound(nums, target, mid);
        res[1] = getRightBound(nums,target, mid);
        break;
      } else {
        high = mid - 1; // target < nums[mid]
      }
    }
    return res;
  }

  private int getLeftBound(int[] nums, int target, int mid) {
    int low = 0, high = mid;
    while (low <= high) {
      if (low == high) {
        break;
      }
      mid = low + ((high - low) >> 1);
      if (nums[mid] == target) {
        high = mid;
      } else if (nums[mid] < target) {
        low = mid + 1;
      }
    }
    return low;
  }

  private int getRightBound(int[] nums, int target, int mid) {
    int low = mid, high = nums.length - 1;
    while (low <= high) {
      if (low == high) {
        break;
      }
      mid = low + ((high - low) >> 1) + 1;
      if (nums[mid] == target) {
        low = mid;
      } else if (nums[mid] > target) {
        high = mid - 1;
      }
    }
    return low;
  }
}
