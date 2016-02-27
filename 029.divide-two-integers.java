/**
 * @see <a href="https://leetcode.com/problems/divide-two-integers/">Divide Two Integers</a>
 */

public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) throw new IllegalArgumentException("Divisor cannot be zero!");
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (divisor == Integer.MIN_VALUE) {
            if (dividend == Integer.MIN_VALUE) return 1;
            return 0;
        }
        
        // all other cases will not have integer overflow.
        int sign = 1;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) sign = -1;

        long newDvd = Math.abs((long) dividend);
        long newDvs = Math.abs((long) divisor);
        int res = 0;
        while (newDvd >= newDvs) {
            long temp = newDvs;
            int multiple = 1; // must this be long ?
            while (newDvd >= (temp << 1)) {
                temp = temp << 1;
                multiple = multiple << 1;
            }
            res += multiple;
            newDvd = newDvd - temp;
        }
        if (sign == -1) res = -res;
        return res;
    }
}
