public class Solution {
	class TrieNode {
		boolean isWord;
		Map<Character, TrieNode> hm;
		TrieNode() {
			isWord = false;
			hm = new HashMap<>();
		}
	}
	
    	public List<String> findWords(char[][] board, String[] words) {
        	constructTrie(words);
        	List<String> res = new ArrayList<>(findWordsSet(board, words));
        	return res;
    	}

	public TrieNode root;
	public void constructTrie(String[] words) {
		root = new TrieNode();
		for (String w : words) addWord(w);
	}
	public void addWord(String w) {
		TrieNode cur = root;
		for (int i = 0; i < w.length(); ++i) {
			if (!cur.hm.containsKey(w.charAt(i))) {
				TrieNode newN = new TrieNode();
				cur.hm.put(w.charAt(i), newN);
			}
			cur = cur.hm.get(w.charAt(i));
			if (i == w.length() - 1) {
				cur.isWord = true;
			}
		}
	}
	
	public Set<String> findWordsSet(char[][] board, String[] words) {
		Set<String> listW = new HashSet<>();
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[0].length; ++j) {
				findWords(root, board, listW, i, j);
			}
		}
		return listW;
	}
	
	public String tw = new String();
	public void findWords(TrieNode trie, char[][] board, Set<String> listW, int i, int j) {
	    	if (trie.isWord) {
			listW.add(tw);
		}
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;		
		
		tw = tw + board[i][j]; // the word at traversal.
		if (!trie.hm.containsKey(board[i][j])) {}
		else {
			char temp = board[i][j];
			board[i][j] = '#';
			findWords(trie.hm.get(temp), board, listW, i + 1, j);
			findWords(trie.hm.get(temp), board, listW, i, j + 1);
			findWords(trie.hm.get(temp), board, listW, i, j - 1);
			findWords(trie.hm.get(temp), board, listW, i - 1, j);
			board[i][j] = temp;
		}
		tw = tw.substring(0, tw.length() - 1);
	}
}
