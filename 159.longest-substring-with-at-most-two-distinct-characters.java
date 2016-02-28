/**
 * @see <a href="https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/">Longest Substring with At Most Two Distinct Characters</a>
 */

public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null) throw new NullPointerException();
        if (s.length() <= 2) return s.length();
        Map<Character, Integer> hm = new HashMap<>();
        hm.put(s.charAt(0), 1);
        int i = 0;
        int j = 0; // inclusive
        int maxLen = 1;
        while (j < s.length()) {
            if (hm.size() <= 2) {
                maxLen = Math.max(maxLen, j - i + 1);
                ++j;
                if (j >= s.length()) break;
                if (hm.containsKey(s.charAt(j))) {
                    hm.put(s.charAt(j), hm.get(s.charAt(j)) + 1);
                } else {
                    hm.put(s.charAt(j), 1);
                }
            } else { // hm.size() > 2
                if (hm.get(s.charAt(i)) == 1) {
                    hm.remove(s.charAt(i));
                } else {
                    hm.put(s.charAt(i), hm.get(s.charAt(i)) - 1);
                }
                ++i;
            }
        }
        return maxLen;
    }
}
