/**
 * @see <a href="https://leetcode.com/problems/first-bad-version/">First Bad Version</a>
 */

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        while (true) {
            if (low >= high) return low;
            int mid = low + ((high - low) >> 1);
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
    }
}
