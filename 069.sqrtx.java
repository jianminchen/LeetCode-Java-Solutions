/**
 * @see <a href="https://leetcode.com/problems/sqrtx/">Sqrt(x)</a>
 */

public class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int low = 1, high = x/2;
        int mid = 0;
        /* the following code has time limit exceeded for x = 3. !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        while (low <= high) {
            mid = low + ((high - low)>>1);
            if (low == high - 1) {
                if (high > x / high) return low;
                else return high;
            }
            if (mid < x / mid) {
                low = mid; // mid can still be the possible answer !!
            }
            else if (mid == x / mid) return mid;
            else {
                // previously written as high = high - 1. are you kidding me?
                high = mid - 1;
            }
        }*/
        while (true) {

            if (low == high) return low;
            if (low == high - 1) {
                if (high > x / high) return low;
                else return high;
            }
            
            mid = low + ((high - low)>>1);
            if (mid < x / mid) {
                low = mid; // mid can still be the possible answer !!
            }
            else if (mid == x / mid) return mid;
            else { // mid > x / mid. mid will never be a answer.
                // previously written as high = high - 1. are you kidding me?
                high = mid - 1;
            }
        }        
        // unreachable statement error !!!!!!!!!?????????
        // return mid;
    }
}
