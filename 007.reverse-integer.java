/**
 * @see <a href="https://leetcode.com/problems/reverse-integer/">Reverse Integer</a>
 */

public class Solution {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) return 0;
        if (x < 0) return -1 * reverse(-1 * x);
        // now we can assume that x >= 0;
        int res = 0;
        int toBeCompared = Integer.MAX_VALUE / 10;
        // the following solution is wrong, input: - 2147483412, output 0, expected: -2143847412
        /*
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
            if ( res > toBeCompared)
                return 0;
        }
        */
        // determine first before you continue. 
        // if current res is not overflow, we can continue, the value at the end of this iteration will not overflow.
        while (x != 0) {
            if ( res > toBeCompared)
                return 0;
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return res;
    }
}
