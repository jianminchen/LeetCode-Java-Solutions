/**
 * @see <a href="https://leetcode.com/problems/add-and-search-word-data-structure-design/">Add and Search Word - Data structure design</a>
 */

public class WordDictionary {

    public class TrieNode {
        public boolean isWord;
        public char c;
        public Map<Character, TrieNode> hm;
        public TrieNode() {
            isWord = false;
            hm = new HashMap<>();
        }
    }
    
    // Adds a word into the data structure.
    private TrieNode root;
    int minLen;
    int maxLen;
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
        if (word.length() == 0) return root.isWord;
        // use minLen and maxLen to check whether we need to do the recursive search first.
        // this can reduce time complexity, can avoid time limit exceeded
        if (word.length() < minLen || word.length() > maxLen) return false;
        return search(word, root);
    }
    
    public boolean search(String word, TrieNode node) {        
        if (word.length() == 0) return node.isWord;
        
        if (node.hm.isEmpty()) return false;
        
        if (word.charAt(0) == '.') {
            boolean found = false;
            Set<Character> set = node.hm.keySet();
            for(char c : set) {
                if (search(word.substring(1), node.hm.get(c))) {
                    found = true;
                    break;
                }
            }
            return found;
        }
        else {
            if (!node.hm.containsKey(word.charAt(0))) return false;
            else {
                return search(word.substring(1), node.hm.get(word.charAt(0)));
            }
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
