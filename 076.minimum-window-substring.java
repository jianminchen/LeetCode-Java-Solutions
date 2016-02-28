/**
 * @see <a href="https://leetcode.com/problems/minimum-window-substring/">Minimum Window Substring</a>
 */

public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null) throw new NullPointerException();
        if (s.length() < t.length()) return "";
        Map<Character, Integer> hmt = getHashMap(t);
        Map<Character, Integer> hms = getHashMap(s.substring(0, t.length()));
        int i = 0;
        int j = t.length() - 1;
        String res = new String();
        int minLen = s.length() + 1;
        while (true) {
            if (covers(hms, hmt)) {
                if (j - i + 1 < minLen) {
                    res = s.substring(i, j + 1);
                    minLen = Math.min(minLen, j - i + 1);
                }
                if (hms.containsKey(s.charAt(i))) {
                    hms.put(s.charAt(i), hms.get(s.charAt(i)) - 1);
                }
                ++i;
            } else {
                ++j;
                if (j >= s.length()) break;
                if (hmt.containsKey(s.charAt(j))) {
                    hms.put(s.charAt(j), hms.containsKey(s.charAt(j)) ? hms.get(s.charAt(j)) + 1 : 1);
                }
            }
        }
        return res;
    }
    private Map<Character, Integer> getHashMap(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            hm.put(s.charAt(i), hm.containsKey(s.charAt(i)) ? hm.get(s.charAt(i)) + 1 : 1);
        }
        return hm;
    }
    private boolean covers(Map<Character, Integer> hms, Map<Character, Integer> hmt) {
        for (char c : hmt.keySet()) {
            if (!hms.containsKey(c) || hms.get(c) < hmt.get(c)) return false;
        }
        return true;
    }
}
