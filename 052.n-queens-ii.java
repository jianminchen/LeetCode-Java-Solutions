/**
 * @see <a href="https://leetcode.com/problems/n-queens-ii/">N-Queens II</a>
 */

public class Solution {
	public int totalNQueens(int n) {
		int res = 0;
		boolean backtrack = false;
		int bValue = 0;
		// though we use a stack to store things.
		// we also need to access all elements in the stack conveniently.
		// thus, we use an array to simulate a stack.
		// the ith element of in the array is the column number in the ith row,
		// for which a queen can be placed.
		List<Integer> stkC = new ArrayList<>();
		
		int i = 0;
		while (true) {
			// we consider the ith row.
			int cand = -1;
			if (backtrack == false) cand = 0;
			else cand = bValue + 1;
			while (cand < n && !canPlace(stkC, cand)) ++cand;
			if (cand >= n) {
				// backtrack
				if (stkC.size() == 0) break; // no way to backtrack.
				backtrack = true;
				bValue = stkC.remove(stkC.size() - 1);
				i = i - 1;
			} else {
				// we can place a queen at i, cand.
				stkC.add(cand);
				i = i + 1;
				backtrack = false;
				bValue = 0;
				if (stkC.size() == n) {
					++res;
					backtrack = true;
					bValue = stkC.remove(stkC.size() - 1);
					i = i - 1;
				}
			}
		}
		return res;
	}
	
	private boolean canPlace(List<Integer> stkC, int cand) {
		// we are placing the stkC.size() th row, and the cand th column.
		int ti = stkC.size();
		int tj = cand;
		for (int i = 0; i < stkC.size(); ++i) {
			int ci = i;
			int cj = stkC.get(i);
			if (Math.abs(ci - ti) == Math.abs(cj - tj)
					|| ci == ti || cj == tj) return false;
		}
		return true;
	}
}
