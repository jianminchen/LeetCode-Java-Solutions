/**
 * @see <a href="https://leetcode.com/problems/implement-trie-prefix-tree/">Implement Trie (Prefix Tree)</a>
 */

class TrieNode {
    // Initialize your data structure here.
    public boolean isWord;
    public char c;
    public Map<Character, TrieNode> hm;
    public TrieNode() {
        isWord = false;
        hm = new HashMap<>();
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word.equals("")) root.isWord = true;
        TrieNode cur = root;
        for (int i = 0; i < word.length(); ++i) {
            if (!cur.hm.containsKey(word.charAt(i))) {
                TrieNode node = new TrieNode();
                node.c = word.charAt(i);
                cur.hm.put(word.charAt(i), node);
            }
            cur = cur.hm.get(word.charAt(i));
            if (i == word.length() - 1) cur.isWord = true;
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word.length() == 0) return root.isWord;
        TrieNode cur = root;
        for (int i = 0; i < word.length(); ++i) {
            if (!cur.hm.containsKey(word.charAt(i))) return false;
            cur = cur.hm.get(word.charAt(i));
            if (i == word.length() - 1) return cur.isWord;
        }
        return true;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix.length() == 0) return true;
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); ++i) {
            if (!cur.hm.containsKey(prefix.charAt(i))) return false;
            cur = cur.hm.get(prefix.charAt(i));
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
