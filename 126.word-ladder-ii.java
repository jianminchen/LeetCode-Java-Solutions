/**
 *  https://leetcode.com/problems/word-ladder-ii/
 */

public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (beginWord.equals(endWord)) {
            List<String> aL = new ArrayList<>();
            aL.add(beginWord);
            res.add(aL);
            return res;
        }
        Set<String> dict = new HashSet<>();
        dict.addAll(wordList);
        dict.add(endWord);
        int dist = getLadderLength(beginWord, endWord, dict);
        
        for (String k : hm.keySet()) {
            hm.put(k, dist - 1 - hm.get(k));
        }
        Set<String> visited = new HashSet<>();
        getLadders(dist - 1, beginWord, endWord, dict, visited);
        return ladders;
    }
    
    private Map<String, Integer> hm = new HashMap<String, Integer>();
    private int getLadderLength(String beginWord, String endWord, Set<String> wordList) {
        int length = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        Queue<Integer> qDist = new LinkedList<>();
        q.add(beginWord);
        qDist.add(0);
        visited.add(beginWord);
        
        while (!q.isEmpty()) {
            String w = q.remove();
            int len = qDist.remove();
            hm.put(w, len);
            if (w.equals(endWord)) {
                length = len + 1;
                break;
            }
            // get all neighbors of w, and add them to the queue, if they have not been visited.
            for (int i = 0; i < w.length(); ++i) {
                for (int c = 'a'; c <= 'z'; ++c) {
                    char[] cArr = w.toCharArray();
                    if (c != cArr[i]) {
                        cArr[i] = (char) c; // don't forget type conversion.
                        String nW = new String(cArr);
                        if (wordList.contains(nW) && !visited.contains(nW)) {
                            q.add(nW);
                            qDist.add(len + 1);
                            visited.add(nW);
                        }
                    }
                }
            }
        }
        return length;
    }
    
    private List<String> stk = new ArrayList<>();
    private List<List<String>> ladders = new ArrayList<>();
    private void getLadders(int dist, String word, String endWord, Set<String> dict, Set<String> visited) {
    	visited.add(word);
    	stk.add(word);
    	if (word.equals(endWord)) {
    		List<String> list = new ArrayList<String>();
    		list.addAll(stk);
    		ladders.add(list);
    	} else if (dist == 0 || hm.get(word) > dist) {}
    	else {
			char[] cArr = word.toCharArray();
    		for (int i = 0; i < word.length(); ++i) {
    			char ci = cArr[i];
    			for (int c = 'a'; c <= 'z'; ++c) {
    				if (c != word.charAt(i)) {
    					cArr[i] = (char) c;
    					String nW = new String (cArr);
    					if (dict.contains(nW) && !visited.contains(nW)) {
    						getLadders(dist - 1, nW, endWord, dict, visited);
    					}
    				}
    			}
    			cArr[i] = ci; // restore.
    		}
    	}
    	visited.remove(word);
    	stk.remove(stk.size() - 1);
    }
}
