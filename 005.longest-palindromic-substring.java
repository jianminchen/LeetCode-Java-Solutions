/**
 * @see <a href="https://leetcode.com/problems/longest-palindromic-substring/">Longest Palindromic Substring</a>
 */

public class Solution {
    public String longestPalindrome(String s) {
        if (s == null) throw new NullPointerException();
        if (s.length() == 0) return "";
        int maxLen = 1;
        int start = 0, end = 0; // inclusive.
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); ++i) {
            isPalindrome[i][i] = true;
        }
        for (int k = 1; k < s.length(); ++k) {
            for (int i = 0; i < s.length() - k; ++i) {
                if ((s.charAt(i) == s.charAt(i + k) && k == 1)
                        || (s.charAt(i) == s.charAt(i + k) && isPalindrome[i + 1][i + k - 1])) {
                    isPalindrome[i][i + k] = true;
                    if (maxLen < k + 1) {
                        maxLen = k + 1;
                        start = i;
                        end = i + k;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
