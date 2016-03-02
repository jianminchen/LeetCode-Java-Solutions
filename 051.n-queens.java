/**
 * @see <a href="https://leetcode.com/problems/n-queens/">N-Queens</a>
 */

public class Solution {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<>();
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
			int cand = backtrack ? bValue + 1 : 0;
			while (cand < n && !canPlace(stkC, cand)) ++cand;
			if (cand >= n) {
				// backtrack
				if (stkC.size() == 0) break; // no way to backtrack.
				backtrack = true;
				bValue = stkC.remove(stkC.size() - 1);
				i = i - 1;
			} else {
				stkC.add(cand);
				i = i + 1;
				backtrack = false;
				bValue = 0;
				if (stkC.size() == n) {
					List<String> aRes = getAResult(stkC);
					res.add(aRes);
					backtrack = true;
					bValue = stkC.remove(stkC.size() - 1);
					i = i - 1;
				}
			}
		}
		return res;
	}
	
	private boolean canPlace(List<Integer> stkC, int cand) {
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
	
	private List<String> getAResult(List<Integer> stkC) {
		List<String> res = new ArrayList<String>();
		for (int i = 0; i < stkC.size(); ++i) {
			char[] charArray = new char[stkC.size()];
			for (int j = 0; j < stkC.size(); ++j) {
				charArray[j] = '.';
			}
			charArray[stkC.get(i)] = 'Q';
			String s = new String(charArray);
			res.add(s);
		}
		return res;
	}
}
