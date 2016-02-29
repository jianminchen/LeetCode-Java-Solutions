/**
 * @see <a href="https://leetcode.com/problems/isomorphic-strings/">Isomorphic Strings</a>
 */

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) throw new NullPointerException();
        HashMap<Character, Character> hm = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i ++) {
            if (hm.containsKey(s.charAt(i))) {
                if (t.charAt(i) != hm.get(s.charAt(i))) return false;
            } else {
                hm.put(s.charAt(i), t.charAt(i));
            }
        }
        Set<Character> keySet = hm.keySet();
        Set<Character> valueSet = new HashSet<Character>();
        for (Character key : keySet) {
            if (valueSet.contains(hm.get(key))) return false;
            else valueSet.add(hm.get(key));
        }
        return true;
    }
}
