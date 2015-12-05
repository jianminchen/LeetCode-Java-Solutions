/**
 * @see <a href="https://leetcode.com/problems/shortest-word-distance/">Shortest Word Distance</a>
 */

public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        HashMap<String, ArrayList<Integer>> hm = new HashMap<String, ArrayList<Integer>>();
        for (int i = 0; i < words.length; i ++) {
            if (!hm.containsKey(words[i])) {
                ArrayList<Integer> al = new ArrayList<Integer>();
                al.add(i);
                hm.put(words[i], al);
            }
            else {
                hm.get(words[i]).add(i);
            }
        }
        ArrayList<Integer> al1 = hm.get(word1);
        ArrayList<Integer> al2 = hm.get(word2);
        int sd = words.length;
        for(int i : al1) {
            for (int j : al2) {
                if (sd > Math.abs(i - j)) {
                    sd = Math.abs(i - j);
                }
            }
        }
        return sd;
    }
}
