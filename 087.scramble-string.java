/**
 * @see <a href="https://leetcode.com/problems/scramble-string/">Scramble String</a>
 */

/**
 * @see <a href="https://leetcode.com/problems/scramble-string/">Scramble String</a>
 */

public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null) throw new NullPointerException();
        if (s1.length() != s2.length()) return false;
        if (s1.length() == 0) return true;
        if (s1.length() == 1) return s1.equals(s2);
        
        Map<Character, Integer> hm1 = new HashMap<>();
        Map<Character, Integer> hm2 = new HashMap<>();
        for (int i = 0; i < s1.length(); ++i) {
            hm1.put(s1.charAt(i), hm1.containsKey(s1.charAt(i)) ? hm1.get(s1.charAt(i)) + 1 : 1);
            hm2.put(s2.charAt(i), hm2.containsKey(s2.charAt(i)) ? hm2.get(s2.charAt(i)) + 1 : 1);
        }
        if (!hm1.equals(hm2)) return false; // help to return false quickly.
        
        for (int i = 1; i <= s1.length() - 1; ++i) {
            if ((isScramble(s1.substring(0, i), s2.substring(0, i)) 
                    && isScramble(s1.substring(i), s2.substring(i)))
                    || (isScramble(s1.substring(0, i), s2.substring(s2.length() - i, s2.length()))
                    && isScramble(s1.substring(i), s2.substring(0, s2.length() - i)))) {
                return true;
            }
        }
        return false;
    }
}
