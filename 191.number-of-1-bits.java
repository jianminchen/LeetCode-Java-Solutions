/**
 * @see <a href="https://leetcode.com/problems/number-of-1-bits/">Number of 1 Bits</a>
 */
 
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1); // clear the last 1 bit
            ++count;
        }
        return count;
    }
}
