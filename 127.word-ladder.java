/**
 * @see <a href="https://leetcode.com/problems/word-ladder/">Word Ladder</a>
 */

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        
        if (beginWord.equals(endWord)) return 0;
        
        Set<String> words = new HashSet<>();
        words.addAll(wordList);
        words.add(beginWord);
        words.add(endWord);
        
        Queue<String> q = new LinkedList<>();
        Queue<Integer> qLen = new LinkedList<>();
        q.add(beginWord);
        qLen.add(0);
        
        words.remove(beginWord);
        
        int length = 1;
        boolean found = false;
        while (!q.isEmpty() && !found) {
            String removed = q.remove();
            length = qLen.remove() + 1;
    
            /* using the following code, still TLE. If function returns a set of strings. */
            // but if we are returning List<String> (ArrayList<String>, we will pass).
            List<String> neighbors = wordNeighbor(removed);
            for (String anb : neighbors) {
                if (words.contains(anb)) { // only considers the remaining words.
                    if (anb.equals(endWord)) return length + 1;
                    q.add(anb);
                    qLen.add(length);
                    words.remove(anb);
                }
            }
            

            // using the following code, finally passed, what's reason for TLE????
            /*
            for (int i = 0; i < removed.length(); i++) {
                char array[] = removed.toCharArray();
                for (array[i] = 'a'; array[i] <= 'z'; array[i]++) {
                    String test = new String(array);
                    if (words.contains(test)) {
                        // do not use "if (isAdjacent(removed, endWord)) return length + 1;"
                        // but choose to test whether they equal here.
                        if (test.equals(endWord)) {
                            return length + 1;
                        }                        
                        q.add(test);
                        qLen.add(length);
                        words.remove(test);
                    }
                }
            }
            */
            

            // using StringBuilder, TLE !!!!!!!!!!!!!!!!!!!!!!!
            // when considering time cost, 
            // it does matter, whether you are using fast array, or slow StringBuilder class !!!!!!!!!!!!
            /*
            for (int i = 0; i < removed.length(); ++i) {
                for (int c = 'a'; c <= 'z'; ++c) {
                    //if (c != removed.charAt(i)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(removed.substring(0, i));
                        sb.append((char)c);
                        sb.append(removed.substring(i + 1));
                        String test = new String(sb);
                        if (words.contains(test)) {
                            if (test.equals(endWord)) return length + 1;
                            q.add(test);
                            qLen.add(length);
                            words.remove(test);
                        }                        
                    //}
                }
            }
            */
        }
        // if we reach this line, must have not found!!!
        return 0;
    }
    
    public List<String> wordNeighbor(String word) 
    {   // using Set<String> as return type will let you TLE !!!!
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < word.length(); i++) {
            char array[] = word.toCharArray();
            for (array[i] = 'a'; array[i] <= 'z'; array[i]++) {
                //if (array[i] != word.charAt(i)) {
                    String test = new String(array);
                    result.add(test);
                //}
            }
        }
        return result;
    }
}
