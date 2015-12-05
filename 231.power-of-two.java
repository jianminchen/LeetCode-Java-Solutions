/**
 * @see <a href="https://leetcode.com/problems/power-of-two/">Power of Two</a>
 */

public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false; // the problem does not assume that n is a positive value!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        while (n > 1) {
            if ( n % 2 != 0) return false;
            n = n/2;
        }
        return true;
    }
}
