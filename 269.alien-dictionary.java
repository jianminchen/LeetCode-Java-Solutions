/**
 * @see <a href="https://leetcode.com/problems/alien-dictionary/">Alien Dictionary</a>
 */
// after getting the precedence order of the characters, the problem becomes the same as the classic topological sorting problem
// and then is similar to Course Schedule, and Course Schedule II. We can use a dependent list, or dependent set, and 
// an indegree count array/map to generate a topological sorting.

public class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> dependList = new HashMap<>();
        Map<Character, Integer> inDegreeMap = new HashMap<>();
        for (int i = 0; i < words.length; ++i) {
            for (int j = 0; j < words[i].length(); ++j) {
                if (!dependList.containsKey(words[i].charAt(j))) {
                    // add an entry in the maps for character that appear at least once
                    dependList.put(words[i].charAt(j), new HashSet<>());
                    inDegreeMap.put(words[i].charAt(j), 0);
                }
            }
        }
        for (int i = 1; i < words.length; ++i) { // get the precedence of the chars from two strings.
            String prev = words[i - 1], cur = words[i];
            int j = 0;
            while (j < prev.length() && j < cur.length() && prev.charAt(j) == cur.charAt(j)) ++j;
            if (j == prev.length() || j == cur.length()) {} // can't get info
            else {
                if (!dependList.get(prev.charAt(j)).contains(cur.charAt(j))) {
                    dependList.get(prev.charAt(j)).add(cur.charAt(j));
                    // when there are duplicates, we can't add 1! So, inside the if
                    inDegreeMap.put(cur.charAt(j), inDegreeMap.get(cur.charAt(j)) + 1);
                }
            }
        }
        
        Queue<Character> q = new LinkedList<>(); // use a queue to do Breadth-First Search
        for (char c : inDegreeMap.keySet()) {
            if (inDegreeMap.get(c) == 0) q.add(c); // add chars that do not depend on any char first
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char c = q.remove();
            sb.append(c);
            for (char dependent : dependList.get(c)) {
                inDegreeMap.put(dependent, inDegreeMap.get(dependent) - 1);
                if (inDegreeMap.get(dependent) == 0) {
                    q.add(dependent);
                }
            }
        }
        if (inDegreeMap.size() == sb.length()) return new String(sb);
        else return "";
    }
}
