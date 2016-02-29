/**
 *  https://leetcode.com/problems/range-sum-query-2d-mutable/
 */ 

/**
 * This is the 2D Segment Tree solution. Notice that, the Quad Tree for this problem has worst case time complexity O(n).
 * The 2D Segment Tree has time complexity of O(lgm * lgn).
 * http://codeforces.com/blog/entry/16363
 * http://apps.topcoder.com/forums/?module=Thread&threadID=633075 
 * http://e-maxx.ru/algo/segment_tree
 * 
 * A simpler solution is to sue Binary Index Tree, which is more subtle to understand.
 */

public class NumMatrix {
	public int[][] t; // storage for the 2D segment tree
	public int[][] a; // storage for the original matrix
	int n; // the number of rows
	int m; // the number of columns.
	public NumMatrix(int[][] matrix) {
	    if (matrix.length == 0 || matrix[0].length == 0) return;
		n = matrix.length;
		m = matrix[0].length;
		a = new int[n][m]; // the original array.
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				a[i][j] = matrix[i][j];
			}
		}
		t = new int[4*n][4*m];// to store information for the segment tree.
		build_x(1, 0, n - 1);
	}
	
	// helper for build, recursively call build_x and build_y.
	private void build_x(int vx, int lx, int rx) {
		if (lx != rx) {
			int mx = (lx + rx) / 2;
			build_x (vx*2, lx, mx);
			build_x (vx*2+1, mx+1, rx);
		}
		build_y (vx, lx, rx, 1, 0, m-1);		
	}
	// helper for build, called by build_x, recursivly call it self.
	private void build_y(int vx, int lx, int rx, int vy, int ly, int ry) {
		if (ly == ry) {
			if (lx == rx) t[vx][vy] = a[lx][ly];
			else t[vx][vy] = t[vx*2][vy] + t[vx*2+1][vy];
		} else {
			int my = (ly + ry) / 2;
			build_y (vx, lx, rx, vy*2, ly, my);
			build_y (vx, lx, rx, vy*2+1, my+1, ry);
			t[vx][vy] = t[vx][vy*2] + t[vx][vy*2+1];
		}
	}
	
        // helper for update, called by update_x, recursively call it self.
	private void update_y (int vx, int lx, int rx, int vy, int ly, int ry, int x, int y, int new_val) {
		if (ly == ry) {
			if (lx == rx) t[vx][vy] = new_val;
			else t[vx][vy] = t[vx * 2][vy] + t[vx * 2 + 1][vy];
		} else {
			int my = (ly + ry) / 2;
			if (y <= my) update_y (vx, lx, rx, vy * 2, ly, my, x, y, new_val);
			else update_y (vx, lx, rx, vy * 2+1, my+1, ry, x, y, new_val);
			t[vx][vy] = t[vx][vy * 2] + t[vx][vy * 2 + 1];
		}
	}
	
	// helper for update, recursively call update_y and update_x
	private void update_x (int vx, int lx, int rx, int x, int y, int new_val) {
		if (lx != rx) {
			int mx = (lx + rx) / 2;
			if (x <= mx) update_x (vx * 2, lx, mx, x, y, new_val);
			else update_x (vx * 2 + 1, mx+1, rx, x, y, new_val);
		}
		update_y (vx, lx, rx, 1, 0, m-1, x, y, new_val);
	}
	
	// api for update
	public void update(int row, int col, int val) {
	    	if (n == 0 || m == 0) return;
		a[row][col] = val;
		update_x(1, 0, n - 1, row, col, val);
	}

        // helper for sumRegion
	private int sum_y (int vx, int vy, int tly, int try_, int ly, int ry) {
		if (ly > ry) return 0;
		if (ly == tly && try_ == ry) return t[vx][vy];
		int tmy = (tly + try_) / 2;
		return sum_y (vx, vy * 2, tly, tmy, ly, Math.min(ry,tmy))
				+ sum_y (vx, vy * 2 + 1, tmy + 1, try_, Math.max(ly, tmy + 1), ry);
	}
	
	// helper for sumRegion
	private int sum_x (int vx, int tlx, int trx, int lx, int rx, int ly, int ry) {
		if (lx > rx) return 0;
		if (lx == tlx && trx == rx) return sum_y(vx, 1, 0, m - 1, ly, ry);
		int tmx = (tlx + trx) / 2;
		return sum_x(vx * 2, tlx, tmx, lx, Math.min(rx, tmx), ly, ry)
				+ sum_x(vx * 2 + 1, tmx + 1, trx, Math.max(lx,tmx + 1), rx, ly, ry);
	}
	
	// api for sumRegion
	public int sumRegion(int row1, int col1, int row2, int col2) {
	    	if (n == 0 || m == 0) return 0;
		return sum_x(1, 0, n - 1, row1, row2, col1, col2);
	}
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);
