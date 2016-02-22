/**
 * @see <a href="https://leetcode.com/problems/string-to-integer-atoi/">String to Integer (atoi)</a>
 */

public class Solution {
    public int myAtoi(String str) {
        if (str == null || str.equals("")) return 0; // invalid.
        int i = 0;
        while (i <str.length() && str.charAt(i) == ' ') i ++;
        int start = i;
        if (i == str.length()) return 0; // invalid.
        char first = str.charAt(start);
        
        // if at certain point, the char is not a digit, disregard the following chars.
        if (first == '-') {
            i ++;
            while (i < str.length() && Character.isDigit(str.charAt(i))) i++;
            int end = i;            
            if (str.substring(start, end).equals("-2147483648")) return Integer.MIN_VALUE;
            if (str.substring(start, end).equals("-2147483647")) return Integer.MIN_VALUE + 1;
            if (start == end - 1) return 0;
            {
                if (subAtoi(str.substring(start + 1, end)) == Integer.MAX_VALUE) {
                    return Integer.MIN_VALUE;
                }
                else return -1*subAtoi(str.substring(start + 1, end));
            }

            
            
        }
        else if (first == '+') {
            i ++;
            while (i < str.length() && Character.isDigit(str.charAt(i))) i++;
            int end = i;

            if (start == end - 1) return 0;
            // what should be returned for "+05", "+006"?
            return subAtoi(str.substring(start + 1, end));
        }
        else if (Character.isDigit(first)) {
            // starts with digits.
            while (i < str.length() && Character.isDigit(str.charAt(i))) i++;
            int end = i;
            return subAtoi(str.substring(start, end));            
        }
        else { // starts with characters that are not '-','+', and digits.
            return 0;
        }
    }
    
    public int subAtoi(String s) { // input starts with digit and ends with digit.
        int res = 0;
        for (int i = 0; i < s.length(); i ++) {
            if (res < Integer.MAX_VALUE / 10) {
                res = res*10 + s.charAt(i) - '0';                
            }
            else if (res == Integer.MAX_VALUE / 10) {
                if (s.charAt(i) > 7) return Integer.MAX_VALUE;
                else {
                    res = res*10 + s.charAt(i) - '0';
                }
            }
            else {
                return Integer.MAX_VALUE;
            }
        }
        return res;
    }
    
    
}
