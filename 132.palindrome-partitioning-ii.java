/**
 * @see <a href="https://leetcode.com/problems/palindrome-partitioning-ii/">Palindrome Partitioning II</a>
 */

public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() <= 1) return 0;
        boolean[][] isPalin = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); ++i) {
            isPalin[i][i] = true;
        }
        for (int k = 1; k < s.length(); ++k) {
            for (int i = 0; i < s.length() - k; ++i) {
                if (s.charAt(i) == s.charAt(i + k)) {
                    if (k == 1 || isPalin[i + 1][i + k - 1])
                        isPalin[i][i + k] = true;
                }
            }
        }
        
        int min[] = new int[s.length() + 1];
        min[0] = -1;
        for (int i = 1; i <= s.length(); ++i) {
            min[i] = i;
            if (isPalin[0][i - 1]) {
                min[i] = 0;
                continue;
            }
            for (int j = i - 1; j >= 0; --j) {
                if (isPalin[j][i - 1]) {
                    min[i] = Math.min(min[i], 1 + min[j]);
                }
            }
        }
        return min[s.length()];
    }

}
