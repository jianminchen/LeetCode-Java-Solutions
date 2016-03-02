/**
 * @see <a href="https://leetcode.com/problems/palindrome-number/">Palindrome Number</a>
 */

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int tempX = x;
        int numDigit = 0;
        while (tempX > 0) {
            tempX = tempX / 10;
            ++numDigit;
        }
        
        for (int i = 0; i < numDigit/2; ++i) {
            if (getIthDigit(x, i) != getIthDigit(x, numDigit - 1 - i)) return false;
        }
        return true;
        
    }
    public int getIthDigit(int x, int i) {
        for (int j = 0; j < i; ++j) {
            x = x / 10;
        }
        return x % 10;
    }
}
