/**
 * @see <a href="https://leetcode.com/problems/word-break/">Word Break</a>
 */

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        // previously written as s.length, wrong!!!!!!
        // arrays use length as a member, strings use length() as a method !!!!!!!!!!!
        boolean[] canBreak = new boolean[s.length() + 1];
        canBreak[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; --i) {
            for (int j = i + 1; j <= s.length(); ++j) {
                // previously written as && canBreak[j + 1], array index out of bound error!!!!!!!!!!!!!!!!
                if (wordDict.contains(s.substring(i, j)) && canBreak[j]) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[0];
    }
}
// what should be returned when s = "", and Set is empty?
// what should be returned when s = "", and Set is not empty?
