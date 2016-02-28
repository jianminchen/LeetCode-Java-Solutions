/**
 * @see <a href="https://leetcode.com/problems/sqrtx/">Sqrt(x)</a>
 */

public class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int low = 1, high = x/2;
        int mid = 0;

        while (true) {
            if (low == high) return low;
            if (low == high - 1) {
                if (high > x / high) return low;
                else return high;
            }
            mid = low + ((high - low) >> 1);
            if (mid < x / mid) {
                low = mid; // mid can still be the possible answer !!
            } else if (mid == x / mid) {
                return mid;
            } else {
                high = mid - 1;
            }
        }
    }
}
