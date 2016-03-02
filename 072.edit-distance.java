/**
 * @see <a href="https://leetcode.com/problems/edit-distance/">Edit Distance</a>
 */

public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) throw new NullPointerException();
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] minDist = new int[len1 + 1][len2 + 1];
        minDist[0][0] = 0;
        for (int j = 1; j <= len2; ++j) minDist[0][j] = j;
        for (int i = 1; i <= len1; ++i) minDist[i][0] = i;
        for (int i = 1; i <= len1; ++i) {
            for (int j = 1; j <= len2; ++j) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    minDist[i][j] = minDist[i - 1][j - 1];
                } else {
                    minDist[i][j] = Math.min(minDist[i - 1][j] + 1, minDist[i][j - 1] + 1);
                    // replace:
                    minDist[i][j] = Math.min(minDist[i][j], minDist[i - 1][j - 1] + 1);
                }
            }
        }
        return minDist[len1][len2];
    }
}
