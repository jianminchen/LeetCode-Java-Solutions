/**
 * @see <a href="https://leetcode.com/problems/word-search/">Word Search</a>
 */

public class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if(dfsHelper(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfsHelper(char[][] board, int x, int y, String word, int start) {
        if(start >= word.length()) return true;
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length) return false;
        if (board[x][y] == word.charAt(start)) {
            ++start;
            char c = board[x][y];
            board[x][y] = '#'; // so latter dfs will not repeatedly use this character
            boolean res = dfsHelper(board, x + 1, y, word, start) || dfsHelper(board, x - 1, y, word, start)
                    || dfsHelper(board, x, y + 1, word, start) || dfsHelper(board, x, y - 1, word, start);
            board[x][y] = c;
            return res;
        }
        return false;
    }
}
