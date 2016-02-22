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
        while (x != 0) {
            if ( res > toBeCompared)
                return 0;
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return res;
    }
}
