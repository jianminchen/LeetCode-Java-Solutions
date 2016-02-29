/**
 * @see <a href="https://leetcode.com/problems/word-ladder/">Word Ladder</a>
 */

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord.equals(endWord)) return 0;
        Set<String> words = new HashSet<>();
        words.addAll(wordList);
        words.add(endWord);
        Queue<String> q = new LinkedList<>();
        Queue<Integer> qLen = new LinkedList<>();
        q.add(beginWord);
        qLen.add(0);
        
        int length = 1;
        boolean found = false;
        while (!q.isEmpty() && !found) {
            String removed = q.remove();
            length = qLen.remove() + 1;
            List<String> neighbors = wordNeighbor(removed);
            for (String anb : neighbors) {
                if (words.contains(anb)) { // only considers the remaining words.
                    if (anb.equals(endWord)) return length + 1;
                    q.add(anb);
                    qLen.add(length);
                    words.remove(anb);
                }
            }
        }
        return 0;
    }
    
    private List<String> wordNeighbor(String word) {
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < word.length(); i++) {
            char array[] = word.toCharArray();
            for (array[i] = 'a'; array[i] <= 'z'; array[i]++) {
                String test = new String(array);
                result.add(test);                
            }
        }
        return result;
    }
}
