/**
 * @see <a href="https://leetcode.com/problems/valid-anagram/">Valid Anagram</a>
 */

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) throw new NullPointerException();
        if (s.length() != t.length()) return false;
        char[] sArray = new char[s.length()];
        char[] tArray = new char[s.length()];
        for (int i = 0; i < s.length(); i ++) {
            sArray[i] = s.charAt(i);
            tArray[i] = t.charAt(i);
        }
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        for (int i = 0; i < s.length(); i ++) {
            if (sArray[i] != tArray[i]) return false;
        }
        return true;
    }
}
