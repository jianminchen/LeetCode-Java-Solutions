/**
 * @see <a href="https://leetcode.com/problems/valid-number/">Valid Number</a>
 */

public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        // cases:
        // with -, +, what should be returned : 
        // "- 5", "+ 5", i.e., do we allow spaces between -, and +? tested false!!
        // "."" false;
        // 
        // .5 true
        // -.5      tested true!!
        // +.5      tested true!!
        // -0.5     true
        // +0.5     true
        // -5. true !!
        // 05       tested true!!
        // 0001     tested true!!
        // "-.1e-0" tested true!!
        // "-.1e+0" tested true!!
        // "-.1E+0" tested false!!
        // "01.5e01" tested true!
        // "e3"     tested false!!
        // "1."     tested true!!
        // "1.e"    tested false!!
        // "1.e1"   tested true!!
        // ".5e"    tested false!!
        // 1.70007e5 true
        // 1.7007e-3 true
        // 1e3 true!!
        // 1e05 false!!
        // 3e0 return true!!
        // 3e return false!!
        // 3.5e!!
        
        // summarize some rules:
        // if e exist, there must be an integer following e.
        // if a dot exist, before the dot, there can be nothing
        // after the dot, there can be nothing. 
        // but, before the dot and after the dot, there should be nothing at the same time.

        // what special symbols/alphabets may exist??? -  +  .  e
        // how may -  +  .  and  e, repectively????
        // - and + can have 2.
        // . and e can have only one.
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
                /*
                if (s1.equals("") && s2.equals("")) return false;
                else if (s1.equals("") && isIntegerWithoutSymbol(s2)) return true;
                else if (isInteger(s1) && s2.equals("")) return true;
                else if (isInteger(s1) && isIntegerWithoutSymbol(s2)) return true;
                */
                return isNumber(s1 + s2);
            }
        }
        return false;
        /* the following is not a good way to approach????
        if (s.charAt(0) == '.') {
            int i = 1;
            while (i < s.length() && s.charAt(i) == '0') ++i;
            int start = i;
            while (i < s.length() && Character.isDigit(s.charAt(i))) ++i;
            int end = i;
            return isInteger(s.substring(i));
        }
        
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            int i = 1;
            while (i < s.length() && Character.isDigit(s.charAt(i))) ++i;
            if (i == 1) return false;
            
        }
        */
        
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
