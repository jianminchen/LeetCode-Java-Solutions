/**
 * @see <a href="https://leetcode.com/problems/factorial-trailing-zeroes/">Factorial Trailing Zeroes</a>
 */

public class Solution {
    public int trailingZeroes(int n) {
        // easy to find out the result is equal to the number of 5 factors in all the numbers that are less than or equal to n.
        int power = 5;
        int count = 0;
        /* using power = power*5 will have time limit exceeded when n = 2147483647.
        // because even n is not integer overflow, power * 5 may become integer overflow, causing power <= n always true!!!!!!!!!!!!
        while (power <= n) {
            count = count + n/power;
            power = power * 5; // this will have time limit exceeded, when n = 2147483647!!!!!!!!!!!!!!!!!!!!!!!!
        }
        return count;
        */
        while (n >= 5) {
            count += n / 5;
            n = n/5;
        }
        return count;
    }
}
