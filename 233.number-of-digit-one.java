/**
 * @see <a href="https://leetcode.com/problems/number-of-digit-one/">Number of Digit One</a>
 */

public class Solution {
    public int countDigitOne(int n) {
        if (n <= 0) return 0;
        else if (n <= 9) return 1;
        int num = n;
        int complete = 1;
        num = num / 10;
        while (num != 0) {
            num = num / 10;
            complete = complete * 10;
        }
        // complete is the complete 10, 100, 1000, numbers for n.

        int highest = n / complete;
        int count = 0; 
        if (highest == 1) {
            count += (n % complete + 1) + countDigitOne(complete - 1) + countDigitOne(n % complete);
        } else { // highest >= 2.
            count += complete;
            count += highest * countDigitOne(complete - 1) + countDigitOne(n % complete);
        }
        return count;
    }
}
