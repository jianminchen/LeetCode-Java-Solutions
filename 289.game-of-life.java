/**
 * @see <a href="https://leetcode.com/problems/game-of-life/">Game of Life</a>
 */

public class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                int nLiveNb = getLiveNeighbor(board, i, j);
                if ((board[i][j] & 1) ==  1) { // using second bit as its state in the next generation
                    if (nLiveNb < 2 || nLiveNb > 3) {} // dies
                    else { // 2, or 3
                        board[i][j] |= 2; // lives
                    }
                } else { // (board[i][j] & 1) == 0
                    if (nLiveNb == 3) board[i][j] |= 2;
                }
            }
        }
        for (int i = 0; i < board.length; ++i) { // use the second bit to overwrite the first bit
            for (int j = 0; j < board[0].length; ++j) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }
    
    private int getLiveNeighbor(int[][] board, int i, int j) {
        int count = 0;
        if (i - 1 >= 0) {
            for (int k = Math.max(0, j - 1); k <= Math.min(board[0].length - 1, j + 1); ++k) {
                if ((board[i - 1][k] & 1) == 1) ++count;
            }
        }
        if (j - 1 >= 0 && (board[i][j - 1] & 1) == 1) ++count;
        if (j + 1 <= board[0].length - 1 && (board[i][j + 1] & 1) == 1) ++count;
        if (i + 1 <= board.length - 1) {
            for (int k = Math.max(0, j - 1); k <= Math.min(board[0].length - 1, j + 1); ++k) {
                if ((board[i + 1][k] & 1) == 1) ++count;
            }
        }
        return count;
    }
}
