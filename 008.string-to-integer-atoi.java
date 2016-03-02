/**
 * @see <a href="https://leetcode.com/problems/string-to-integer-atoi/">String to Integer (atoi)</a>
 */

public class Solution {
    public int myAtoi(String str) {
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') ++i;
        if (i == str.length()) return 0;
        int sign = 1;
        if (str.charAt(i) == '+') {
            ++i;
        } else if (str.charAt(i) == '-') {
            sign = -1;
            ++i;
        }
        int start = i;
        int res = 0;
        while(i < str.length() && Character.isDigit(str.charAt(i))) {
            // check overflow
            if (res > Integer.MAX_VALUE / 10 ) {
                if (sign == -1) return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            } else if (res == Integer.MAX_VALUE / 10) {
                if (sign == -1 && str.charAt(i) >= '8') return Integer.MIN_VALUE;
                if (sign == 1 && str.charAt(i) >= '7') return Integer.MAX_VALUE;
            }
            res = res * 10 + str.charAt(i) - '0';
            ++i;
        }
        return sign * res;
    }
}
