/**
 * @see <a href="https://leetcode.com/problems/alien-dictionary/">Alien Dictionary</a>
 */

public class Solution {
    public String alienOrder(String[] words) {
        // Wrong understanding of the problem:
        // words are sorted lexicographically, not chars in words are sorted lexicographically.!!!!!!!!!!!
        /*
        Map<Character, Set<Character>> dependList = new HashMap<>();
        for (int i = 0; i < words.length; ++i) {
            if (words[i] != null && words[i].length() != 0) {
                if (!dependList.containsKey(words[i].charAt(0))) {
                        Set<Character> s = new HashSet<>();
                        dependList.put(words[i].charAt(0), s);
                }
                // do not need to distinguish words[i].length() == 1, and >=2.
                // the two cases can be included in a general code.
                for (int j = 1; j < words[i].length(); ++j) {
                    if (!dependList.containsKey(words[i].charAt(j))) {
                        Set<Character> s = new HashSet<>();
                        dependList.put(words[i].charAt(j), s);
                    }
                    if (words[i].charAt(j) != words[i].charAt(j - 1)) {
                        dependList.get(words[i].charAt(j)).add(words[i].charAt(j - 1));
                    }
                }
            }
        }*/

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
                    // previously, used dependList.removeKey(), wrong !!!!!!!!!!!!!!!!
                    // remove is by default using key, the method name is just remove()!!!!!!!!!!!!!!!!
                    // dependList.remove(c); // remove c, or add c to string.
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
