/**
 * @see <a href="https://leetcode.com/problems/find-peak-element/">Find Peak Element</a>
 */

public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null) throw new NullPointerException();
        int low = 0, high = nums.length - 1;
        int mid = -1;
        while (low <= high) {
            if (low == high) break;
            mid = low + ((high - low) >> 1);
            if (nums[mid] < nums[mid + 1]) { // should compare nums[mid] and nums[mid + 1]
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
