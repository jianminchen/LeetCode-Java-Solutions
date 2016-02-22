/**
 * @see <a href="https://leetcode.com/problems/shortest-word-distance-ii/">Shortest Word Distance II</a>
 */

public class WordDistance {
    Map<String, List<Integer>> hm;
    public WordDistance(String[] words) {
        hm = new HashMap<String, List<Integer>>();
        for (int i = 0; i < words.length; ++i) {
            if (!hm.containsKey(words[i])) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                hm.put(words[i], list);
            }
            else {
                hm.get(words[i]).add(i);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = hm.get(word1);
        List<Integer> list2 = hm.get(word2);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list1.size(); ++i) {
            for (int j = 0; j < list2.size(); ++j) {
                min = Math.min(min, Math.abs(list1.get(i) - list2.get(j)));
            }
        }
        return min;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");
