/**
 * @see <a href="https://leetcode.com/problems/word-break/">Word Break</a>
 */

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] canBreak = new boolean[s.length() + 1];
        canBreak[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; --i) {
            for (int j = i + 1; j <= s.length(); ++j) {
                if (wordDict.contains(s.substring(i, j)) && canBreak[j]) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[0];
    }
}
