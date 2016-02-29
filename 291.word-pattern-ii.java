/**
 * @see <a href="https://leetcode.com/problems/word-pattern-ii//">Word Pattern Match II</a>
 */

public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
    	Set<String> set = new HashSet<>();
    	Map<Character, String> hm = new HashMap<>();
    	
        return wordPatternMatch(set, hm, pattern, str);
    }
    
    private boolean wordPatternMatch(Set<String> set, Map<Character, String> hm, String pattern, String str) {
    	if (pattern.length() == 0 && str.length() == 0) return true;
    	else if (pattern.length() == 0 && str.length() != 0) return false;
    	else if (pattern.length() != 0 && str.length() == 0) return false;

    	if (hm.containsKey(pattern.charAt(0))) {
    	    String w = hm.get(pattern.charAt(0));
    	    if (str.length() < w.length()) return false;
    	    else if (!str.substring(0, w.length()).equals(w)) return false;
    	    else return wordPatternMatch(set, hm, pattern.substring(1), str.substring(w.length()));
    	} else {
            for (int i = 1; i <= str.length(); ++i) {
                if (!set.contains(str.substring(0, i))) {
                    set.add(str.substring(0, i));
                    hm.put(pattern.charAt(0), str.substring(0, i));
                    if (wordPatternMatch(set, hm, pattern.substring(1), str.substring(i))) return true;
                    set.remove(str.substring(0, i));
                    hm.remove(pattern.charAt(0));
                }
            }
            return false;
    	}
    }
}
