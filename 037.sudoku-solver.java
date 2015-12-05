/**
 * @see <a href="https://leetcode.com/problems/sudoku-solver/">Sudoku Solver</a>
 */

public class Solution {
	public void solveSudoku(char[][] board) {
		List<int[]> locs = locsToFill(board);
		boolean[][][] exist = new boolean[3][board.length][board.length];
		// let exist[0][i][j] be whether number j exist in row i.
		// let exist[1][i][j] be whether number j exist in column i.
		// let exist[2][j][j] be whether number j exist in grid i.
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board.length; ++j) {
				char c = board[i][j];
				if (c != '.') { // c can be from '1' to '9'.
					if (exist[0][i][c - '1'] || exist[1][j][c - '1'] ||
							exist[2][(i / 3) * 3 + j / 3][c - '1']) return;
					exist[0][i][c - '1'] = true;
					exist[1][j][c - '1'] = true;
					exist[2][(i / 3) * 3 + j / 3][c - '1'] = true;
				}
			}
		}
		boolean backtrack = false;
		int bValue = 0;
		Stack<Integer> stk = new Stack<>();
		
		for (int i = 0; i < locs.size(); ++i) {
			int cand = -1;
			// cand is the number to fill in the board.
			if (backtrack == false) cand = 1;
			else cand = bValue + 1;
			int ci = locs.get(i)[0];
			int cj = locs.get(i)[1];
			// System.out.print(i + " " + cand + "\n");
			// a small typo can mean totally different things!
			// previously, write as exist[1][ci][cand - 1], get wrong answer!!!
			while (cand < 10 && 
					(exist[0][ci][cand - 1] || exist[1][cj][cand - 1] ||
							exist[2][(ci / 3) * 3 + cj / 3][cand - 1]))
				++cand;
			// System.out.print(i + " " + ci + " " + cj + " " + cand + "\n");
			
			if (cand > 9) {
				// need to backtrack
				if (stk.isEmpty()) break; // no way to backtrack
				backtrack = true;
				bValue = stk.pop();
				int lasti = locs.get(i - 1)[0];
				int lastj = locs.get(i - 1)[1];
				exist[0][lasti][bValue - 1] = false;
				exist[1][lastj][bValue - 1] = false;
				exist[2][(lasti / 3) * 3 + lastj / 3][bValue - 1] = false;
				// --i is not enough!! we need to go back to consider i - 1.
				// --i.
				i = i - 2;
			}
			else { // use the currant cand value;
				exist[0][ci][cand - 1] = true;
				exist[1][cj][cand - 1] = true;
				exist[2][(ci / 3) * 3 + cj / 3][cand - 1] = true;
				stk.push(cand);
				backtrack = false;
				bValue = 0;
			}
		}
		// after that, fill in the numbers to the board.
		if (locs.size() == stk.size()) {
			for (int i = locs.size() - 1; i >= 0; --i) {
				int ci = locs.get(i)[0];
				int cj = locs.get(i)[1];
				board[ci][cj] = (char) (stk.pop() + '0');
			}
		}
	}
	
	public List<int[]> locsToFill(char[][] board) {
		List<int[]> locs = new ArrayList<>();
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board.length; ++j) {
				if (board[i][j] == '.') {
					locs.add(new int[]{i, j});
				}
			}
		}
		return locs;
	}
}
