/**
 * @see <a href="https://leetcode.com/problems/surrounded-regions/">Surrounded Regions</a>
 */

public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length <= 2 || board[0].length <= 2) return;
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        // traverse the first row, last column, last row, and the first column
        for (int j = 0; j < board[0].length - 1; ++j) {
            if (board[0][j] == 'O' && visited[0][j] == false) {
                visit(board, visited, 0, j);
            }
            
        }
        for (int i = 0; i < board.length - 1; ++i) {
            if (board[i][board[0].length - 1] == 'O' && visited[i][board[0].length - 1] == false) {
                visit(board, visited, i, board[0].length - 1);
            }
        }
        for (int j = board[0].length - 1; j >= 1; --j) {
            if (board[board.length - 1][j] == 'O' && visited[board.length - 1][j] == false) {
                visit(board, visited, board.length - 1, j);
            }
        }
        for (int i = board.length - 1; i >= 1; --i) {
            if (board[i][0] == 'O' && visited[i][0] == false) {
                visit(board, visited, i, 0);
            }
        }
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == 'O' && visited[i][j] == false) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    
    public void visit(char[][] board, boolean[][] visited, int i, int j) {
        visited[i][j] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        while (!q.isEmpty()) {
            int[] cur = q.remove();
            for (int[] n : getNeighbors(cur, board)) {
                if (board[n[0]][n[1]] == 'O' && !visited[n[0]][n[1]]) {
                    visited[n[0]][n[1]] = true;
                    q.add(n);
                }
            }
        }
    }
    
    public List<int[]> getNeighbors(int[] cur, char[][] board) {
        int i = cur[0];
        int j = cur[1];
        List<int[]> list = new ArrayList<>();
        if (i - 1 >= 0) list.add(new int[]{i - 1, j});
        if (i + 1 <= board.length - 1) list.add(new int[]{i + 1, j});
        if (j - 1 >= 0) list.add(new int[]{i, j - 1});
        if (j + 1 <= board[0].length - 1) list.add(new int[]{i, j + 1});
        return list;
    }
}
