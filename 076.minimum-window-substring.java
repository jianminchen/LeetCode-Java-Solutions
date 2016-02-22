/**
 * @see <a href="https://leetcode.com/problems/minimum-window-substring/">Minimum Window Substring</a>
 */

public class Solution {
    public String minWindow(String s, String t) {
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
                if (hms.containsKey(s.charAt(i)))
                    hms.put(s.charAt(i), hms.get(s.charAt(i)) - 1);
                ++i;
            }
            else {
                ++j;
                if (j >= s.length()) break;
                if (hmt.containsKey(s.charAt(j))) {
                    if (!hms.containsKey(s.charAt(j))) {
                        hms.put(s.charAt(j), 0);
                    }
                    hms.put(s.charAt(j), hms.get(s.charAt(j)) + 1);
                }
            }
        }
        return res;
    }
    public Map<Character, Integer> getHashMap(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            if (!hm.containsKey(s.charAt(i))) hm.put(s.charAt(i), 0);
            hm.put(s.charAt(i), hm.get(s.charAt(i)) + 1);
        }
        return hm;
    }
    public boolean covers(Map<Character, Integer> hms, Map<Character, Integer> hmt) {
        Set<Character> set = hmt.keySet();
        for (char c : set) {
            if (!hms.containsKey(c) || hms.get(c) < hmt.get(c)) return false;
        }
        return true;
    }
}
