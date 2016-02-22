/**
 * @see <a href="https://leetcode.com/problems/factorial-trailing-zeroes/">Factorial Trailing Zeroes</a>
 */

public class Solution {
    public int trailingZeroes(int n) {
        int power = 5;
        int count = 0;

        while (n >= 5) {
            count += n / 5;
            n = n/5;
        }
        return count;
    }
}
