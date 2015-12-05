/**
 * @see <a href="https://leetcode.com/problems/number-of-1-bits/">Number of 1 Bits</a>
 */

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int w = 0;
        int i = 0;
        while (i < 32) {
            w += (n&1);
            n = n>>1;
            i ++;
        }
        return w;
        
        // previously written as follows, has time limit exceeded!!!!!!!!!!!!
        // seems the n != 0 check is more time consuming than i < 32!!!!!!!!!!!!!!!!
        /*
        int w = 0;
        while (n != 0) {
            w += (n&1);
            n = n>>1;
            i ++;
        }
        return w;
        */
    }
}
