/**
 * @see <a href="https://leetcode.com/problems/one-edit-distance/">One Edit Distance</a>
 */

public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null) throw new NullPointerException();
        if (Math.abs(s.length() - t.length()) >= 2) return false;
        if (s.length() == t.length()) {
            int i = 0;
            while (i < s.length() && s.charAt(i) == t.charAt(i)) ++i;
            if (i == s.length()) {
                return false;
            } else {
                return s.substring(i + 1).equals(t.substring(i + 1));
            }
        } else {
            if (s.length() < t.length()) return isOneEditDistance(t, s);
            int i = 0;
            while (i < s.length() && i < t.length() && s.charAt(i) == t.charAt(i)) ++i;
            return s.substring(i + 1).equals(t.substring(i));
        }
    }
}
