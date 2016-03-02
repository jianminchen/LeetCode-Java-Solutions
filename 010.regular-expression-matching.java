/**
 * @see <a href="https://leetcode.com/problems/regular-expression-matching/">Regular Expression Matching</a>
 */

public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) throw new NullPointerException();
        int sL = s.length(), pL = p.length();
        if (sL == 0 && pL == 0) return true;
        if (pL == 0 && sL != 0) return false;
        
        if (pL == 1) {
            if (sL != 1) return false;
            if (p.charAt(0) == '.') return true;
            else return p.charAt(0) == s.charAt(0);
        } else { // pL >= 2.
            if (p.charAt(1) != '*') {
                if (sL == 0) return false;
                
                if (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)) {
                    if (isMatch(s.substring(1), p.substring(1))) return true;
                }
            } else { // p.charAt(1) == '*'
                if (isMatch(s, p.substring(2))) return true;
                if (p.charAt(0) == '.') {
                    for (int i = 1; i <= sL; ++i) {
                        if (isMatch(s.substring(i), p.substring(2))) return true;
                    }
                } else {
                    int i = 0;
                    while (i < sL && s.charAt(i) == p.charAt(0)) {
                        if (isMatch(s.substring(i + 1), p.substring(2))) return true;
                        ++i;
                    }
                }
            }
        }
        return false;
    }
}
