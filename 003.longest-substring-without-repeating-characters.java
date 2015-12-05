/**
 * @see <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">Longest Substring Without Repeating Characters</a>
 */

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        int i = 0;
        int j = 1;
        int maxLen = 1;
        while (j < s.length()) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                ++i;
            }
            else {
                set.add(s.charAt(j));
                maxLen = Math.max(maxLen, j - i + 1);
                ++j;
            }
        }
        return maxLen;
    }
}
