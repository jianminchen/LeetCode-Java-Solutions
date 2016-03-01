/**
 * @see <a href="https://leetcode.com/problems/strobogrammatic-number/">Strobogrammatic Number</a>
 */

public class Solution {
    public boolean isStrobogrammatic(String num) {
        if (num == null) throw new NullPointerException();
        if (num.length() == 0) return true;
        // if the length is odd, the middle digit must be 0, 1, or 8 to become a strobogrammatic number
        if (num.length() % 2 == 1 && num.charAt(num.length() >> 1) != '0'
                && num.charAt(num.length() >> 1) != '1'
                && num.charAt(num.length() >> 1) != '8') return false;
        // I use ' ' to indicate it is not a valid number.
        char[][] chart = {{'0', '0'}, {'1', '1'}, {'2', ' '}, {'3', ' '}, {'4', ' '}, 
                {'5', ' '}, {'6', '9'}, {'7', ' '}, {'8', '8'}, {'9', '6'}};
        for (int i = 0; i < num.length() >> 1; ++i) {
            if (chart[num.charAt(i) - '0'][1] == ' ' 
                    || chart[num.charAt(i) - '0'][1] != num.charAt(num.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
