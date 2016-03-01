/**
 * @see <a href="https://leetcode.com/problems/find-the-duplicate-number/">Find the Duplicate Number</a>
 */

public class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null) throw new NullPointerException();
        if (nums.length == 0) return -1;
        int low = 1, high = nums.length - 1;
        int n = nums.length - 1;
        while (true) {
            if (low == high) break;
            int mid = low + ((high - low) >> 1);
            int count = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] > mid) ++count;
            }
            if (count >= n + 1 - mid) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}
