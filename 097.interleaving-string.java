/**
 * @see <a href="https://leetcode.com/problems/interleaving-string/">Interleaving String</a>
 */

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        // dynamic programming: isInter[i][j] indicates whether, 
        // s3.substring(0, i + j) is iterleaving string of s1.substring(0, i), and s2.substring(0, j).
        boolean isInter[][] = new boolean[s1.length() + 1][s2.length() + 1];
        isInter[0][0] = true;
        for (int j = 1; j < s2.length() + 1; ++j) {
            isInter[0][j] = isInter[0][j - 1] && (s2.charAt(j - 1) == s3.charAt(j - 1));
        }
        for (int i = 1; i < s1.length() + 1; ++i) {
            isInter[i][0] = isInter[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }
        for (int i = 1; i < s1.length() + 1; ++i) {
            for (int j = 1; j < s2.length() + 1; ++j) {
                if ((s2.charAt(j - 1) == s3.charAt(i + j - 1) && isInter[i][j - 1])
                        || (s1.charAt(i - 1) == s3.charAt(i + j - 1) && isInter[i - 1][j])) {
                    isInter[i][j] = true;
                }
            }
        }
        return isInter[s1.length()][s2.length()];
    }
}
