/**
 * @see <a href="https://leetcode.com/problems/wildcard-matching/">Wildcard Matching</a>
 */

public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) throw new NullPointerException();
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        match[s.length()][p.length()] = true;
        int j = p.length() - 1;
        while (j >= 0 && p.charAt(j) == '*') {
            match[s.length()][j] = true;
            --j;
        }
        for (int i = s.length() - 1; i >= 0; --i) {
            for (int k = p.length() - 1; k >= 0; --k) {
                if (p.charAt(k) == '?' || p.charAt(k) == s.charAt(i)) {
                    match[i][k] = match[i + 1][k + 1];                    
                } else if (p.charAt(k) == '*') {
                    match[i][k] = match[i + 1][k] || match[i][k + 1];
                } else {
                    match[i][k] = false;
                }
            }
        }
        return match[0][0];
    }
}
