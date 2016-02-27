/**
 * @see <a href="https://leetcode.com/problems/sudoku-solver/">Sudoku Solver</a>
 */

public class Solution {
  public void solveSudoku(char[][] board) {
    if (board == null) {
      throw new NullPointerException();
    }
    if (board.length != 9 || board[0].length != 9) {
      throw new IllegalArgumentException("Board lengths should be 9.");
    }
    List<int[]> emptyLocs = new ArrayList<>();
    boolean[][][] exist = new boolean[3][board.length][board[0].length];
    preprocess(board, emptyLocs, exist);

    boolean backtrack = false;
    int prevValue = 0;
    for (int i = 0; i < emptyLocs.size(); ++i) {
      int cand = backtrack ? 1 + prevValue : 1; 
      int curRow = emptyLocs.get(i)[0], curCol = emptyLocs.get(i)[1];
      while (cand < 10 && (exist[0][curRow][cand - 1]
          || exist[1][curCol][cand - 1]
          || exist[2][(curRow / 3) * 3 + curCol / 3][cand - 1])) {
        ++cand; // seek for a valid candidate number
      }
      if (cand > 9) { // need to backtrack
        if (i == 0) {
          break; // no way to backtrack
        }
        backtrack = true;
	int prevRow = emptyLocs.get(i - 1)[0];
        int prevCol = emptyLocs.get(i - 1)[1];
        prevValue = board[prevRow][prevCol] - '0'; // record previous value
        exist[0][prevRow][prevValue - 1] = false;
        exist[1][prevCol][prevValue - 1] = false;
        exist[2][(prevRow / 3) * 3 + prevCol / 3][prevValue - 1] = false;
        i = i - 2;
      } else { // do not backtrack; go to next empty location
        backtrack = false;
        exist[0][curRow][cand - 1] = true;
        exist[1][curCol][cand - 1] = true;
        exist[2][(curRow / 3) * 3 + curCol / 3][cand - 1] = true;
        board[curRow][curCol] = (char) (cand + '0');
      }
    }
  }

  private void preprocess(char[][] board, List<int[]> emptyLocs, 
      boolean[][][] exist) {
    for (int i = 0; i < board.length; ++i) {
      for (int j = 0; j < board[0].length; ++j) {
        char c = board[i][j];
        if (c != '.') {
          exist[0][i][c - '1'] = true;
          exist[1][j][c - '1'] = true;
          exist[2][(i / 3) * 3 + j / 3][c - '1'] = true;
        } else {
          emptyLocs.add(new int[]{i, j});
        }
      }
    }
  }
}
