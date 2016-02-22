/**
 * @see <a href="https://leetcode.com/problems/valid-number/">Valid Number</a>
 */

public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();

        if (s.length() == 0) return false;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == ' ') return false;
        }
        int dotLoc = -1;
        int eLoc = -1;
        int dotCount = 0;
        int eCount = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '.') {
                ++dotCount;
                dotLoc = i;
            }
            if (s.charAt(i) == 'e') {
                ++eCount;
                eLoc = i;
            }
        }
        if (dotCount > 1 || eCount > 1) return false;
        if (dotCount == 0 && eCount == 0) return isInteger(s);
        else if (dotCount == 0 && eCount == 1) {
            if (isInteger(s.substring(0, eLoc)) && isInteger(s.substring(eLoc + 1)))
                return true;
        }
        else if (eCount == 0 && dotCount == 1) {
            if ((isInteger(s.substring(0, dotLoc)) && 
                (s.substring(dotLoc + 1).equals("") || isIntegerWithoutSymbol(s.substring(dotLoc + 1)))) ||
                ((s.substring(0, dotLoc).equals("") || s.substring(0, dotLoc).equals("+") || 
                 s.substring(0, dotLoc).equals("-")) && isIntegerWithoutSymbol(s.substring(dotLoc + 1))))
                return true;
        }
        else { // eCount == 1, dotCount == 1
            if (eLoc < dotLoc) return false;
            String s1 = s.substring(0, dotLoc);
            String s2 = s.substring(dotLoc + 1, eLoc);
            String s3 = s.substring(eLoc + 1);
            if (isInteger(s3)) {
                return isNumber(s1 + s2);
            }
        }
        return false;
        
    }
    public boolean isInteger(String s) {
        if (s.length() == 0) return false;
        if (s.charAt(0) == '-' || s.charAt(0) == '+') return isIntegerWithoutSymbol(s.substring(1));
        else return isIntegerWithoutSymbol(s);
    }
    public boolean isIntegerWithoutSymbol(String s) {
        if (s.equals("")) return false;
        for (int i = 0; i < s.length(); ++i) {
            if (!Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }
}
