/**
 * @see <a href="https://leetcode.com/problems/bitwise-and-of-numbers-range/">Bitwise AND of Numbers Range</a>
 */

public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int i = 31;
        for (; i >= 0; --i) {
            if (((m >> i) & 1) != ((n >> i) & 1)) break;
        }
        if (m == n) return m;
        return (m >> (i + 1)) << (i + 1);
    }
}
