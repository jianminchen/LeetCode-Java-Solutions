/**
 * @see <a href="https://leetcode.com/problems/word-pattern/">Word Pattern</a>
 */

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        // for characters in the pattern, if two characters are the same, they must map to the same word.
        // if two characters are not the same, they must map to different words.
        HashMap<Character, String> hm = new HashMap<Character, String>();
        HashSet<String> valueSet = new HashSet<String>();
        
        int si = 0; // where we are in the string.
        for (int i = 0; i < pattern.length(); ++i) {
            if (si >= str.length()) return false;
            int start = si;
            while (si < str.length() && str.charAt(si) != ' ') ++si;
            int end = si;
            String word = str.substring(start, end);
            if (hm.containsKey(pattern.charAt(i))) {
                if (!word.equals(hm.get(pattern.charAt(i)))) return false;
            } else {
                hm.put(pattern.charAt(i), word);
                if (valueSet.contains(word)) return false;
                valueSet.add(word);
            }
            ++si; // points to the beginning of the next word.
        }
        // pattern finishes, but there are still some words in the string.
        if (si < str.length()) return false; 
        return true;
    }
}
