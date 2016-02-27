/**
 * @see <a href="https://leetcode.com/problems/powx-n/">Pow(x, n)</a>
 */

public class Solution {
    public double myPow(double x, int n) {
        // what if x < 0; what if n < 0?
        if (n == 0) return 1;
        if (n < 0) { // consider integer overflow !
            if (n == Integer.MIN_VALUE) {
                return 1/myPow(x, Integer.MIN_VALUE + 1)/x;
            }
            return 1/myPow(x, -n);
        }
        if (n == 1) return x;
        if (n % 2 == 0) {
            double half = myPow(x, n/2);
            return half * half;
        } else {
            double half = myPow(x, n/2);
            return half * half * x;
        }
    }
}
