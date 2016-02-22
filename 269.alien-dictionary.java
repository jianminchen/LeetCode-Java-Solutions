/**
 * @see <a href="https://leetcode.com/problems/alien-dictionary/">Alien Dictionary</a>
 */

public class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> dependList = new HashMap<>();
        for (int i = 0; i < words.length; ++i) {
            for (int j = 0; j < words[i].length(); ++j) {
                if (!dependList.containsKey(words[i].charAt(j))) {
                    Set<Character> s = new HashSet<>();
                    dependList.put(words[i].charAt(j), s);
                }
            }
        }
        
        for (int i = 1; i < words.length; ++i) {
            String prev = words[i - 1];
            String cur = words[i];
            // get the precedence of the chars from these two strings.
            int j = 0;
            while (j < prev.length() && j < cur.length() && prev.charAt(j) == cur.charAt(j)) ++j;
            if (j == prev.length() || j == cur.length()) ; // can't get info
            else {
                dependList.get(cur.charAt(j)).add(prev.charAt(j));
            }
        }
        
        
        StringBuilder sb = new StringBuilder();
        while (!dependList.isEmpty()) {
            Set<Character> charSet = dependList.keySet(); // consider all chars in the remaining dependList
            List<Character> charToRemove = new ArrayList<>();
            for (char c : charSet) { // concurrent modification exception ????
                if (dependList.get(c).isEmpty()) {
                    charToRemove.add(c);
                    sb.append(c);
                    for (char cc : charSet) { // update all dependLists.
                        if (dependList.get(cc).contains(c)) {
                            dependList.get(cc).remove(c);
                        }
                    }
                }
            }
            
            for (char c : charToRemove) {
                dependList.remove(c);
            }
            if (charToRemove.size() == 0) return "";
        }
        return new String(sb);
    }
}
