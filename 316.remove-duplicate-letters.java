/**
 * https://leetcode.com/problems/remove-duplicate-letters/
 */

public class Solution {
    private final int CHAR_COUNT = 26;
    public String removeDuplicateLetters(String s) {
        if (s == null) throw new NullPointerException();
        if (s.length() <= 1) return s;
        int n = s.length();
        int[] count = new int[CHAR_COUNT];
        boolean[] visited = new boolean[CHAR_COUNT];
        for (int i = 0; i < n; ++i) {
            ++count[s.charAt(i) - 'a'];
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            --count[c - 'a'];
            if (visited[c - 'a']) continue;
            while (sb.length() > 0 && c < sb.charAt(sb.length() - 1) 
                    && count[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                visited[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(c);
            visited[c - 'a'] = true;
        }
        return sb.toString();
    }
}
