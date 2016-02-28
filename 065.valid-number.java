/**
 * @see <a href="https://leetcode.com/problems/valid-number/">Valid Number</a>
 */

public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) return false;
        int i = 0;
        int ePos = -1;
        for (; i < s.length(); ++i) {
            if (s.charAt(i) == 'e') {
                ePos = i;
                break;
            }
        }
        if (ePos == -1) return isFloating(s);
        else return isFloating(s.substring(0, ePos)) && isInteger(s.substring(ePos + 1));
    }
    
    private boolean isFloating(String s) {
        if (s.length() == 0) return false;
        int dotPos = -1;
        int i = 0; // need to remove the symbol first. 
        if (s.charAt(i) == '+' || s.charAt(i) == '-') ++i;
        int start = i;
        
        for (; i < s.length(); ++i) {
            if (s.charAt(i) == '.') {
                dotPos = i;
                break;
            }
        }
        if (dotPos == -1) {
            return isUnsignedInteger(s.substring(start));
        } else {
            if (start == dotPos) {
                return isUnsignedInteger(s.substring(dotPos + 1));
            } else if (dotPos == s.length() - 1) {
                return isUnsignedInteger(s.substring(start, dotPos));
            } else {
                return isUnsignedInteger(s.substring(start, dotPos)) 
                        && isUnsignedInteger(s.substring(dotPos + 1));
            }
        }
    }
    
    private boolean isInteger(String s) {
        if (s.length() == 0) return false;
        int i = 0;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') ++i;
        return isUnsignedInteger(s.substring(i));
        
    }
    
    private boolean isUnsignedInteger(String s) {
        if (s.length() == 0) return false;
        for (int i = 0; i < s.length(); ++i) {
            if (!Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }
}
