/**
 * @see <a href="https://leetcode.com/problems/add-and-search-word-data-structure-design/">Add and Search Word - Data structure design</a>
 */

public class WordDictionary {
    private class TrieNode {
        boolean isWord;
        char c;
        Map<Character, TrieNode> hm;
        TrieNode() {
            isWord = false;
            hm = new HashMap<>();
        }
    }
    
    // Adds a word into the data structure.
    private TrieNode root;
    private int minLen;
    private int maxLen;
    public WordDictionary() {
        root = new TrieNode();
        minLen = Integer.MAX_VALUE;
        maxLen = Integer.MIN_VALUE;
    }
    public void addWord(String word) {
        if (word.equals("")) root.isWord = true;
        TrieNode cur = root;
        for (int i = 0; i < word.length(); ++i) {
            if (!cur.hm.containsKey(word.charAt(i))) {
                TrieNode node = new TrieNode();
                node.c = word.charAt(i);
                cur.hm.put(word.charAt(i), node);
            }
            cur = cur.hm.get(word.charAt(i));
            if (i == word.length() - 1) {
                cur.isWord = true;
                minLen = Math.min(minLen, word.length());
                maxLen = Math.max(maxLen, word.length());
            }
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if (word.length() < minLen || word.length() > maxLen) return false;
        return search(word, root);
    }
    
    public boolean search(String word, TrieNode node) {        
        if (word.length() == 0) return node.isWord;
        if (node.hm.isEmpty()) return false;
        if (word.charAt(0) == '.') {
            for(char c : node.hm.keySet()) {
                if (search(word.substring(1), node.hm.get(c))) {
                    return true;
                }
            }
            return false;
        } else {
            if (!node.hm.containsKey(word.charAt(0))) {
                return false;
            } else {
                return search(word.substring(1), node.hm.get(word.charAt(0)));
            }
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
