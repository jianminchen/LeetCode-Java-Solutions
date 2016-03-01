/**
 * @see <a href="https://leetcode.com/problems/graph-valid-tree/">Graph Valid Tree</a>
 */
// using a queue for Breadth-First Search, the queue stores the edges, instead of vertices.
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> listNeighbor = getListNeighbors(n, edges); // use function to simplify coding.
        boolean visited[] = new boolean[n];
        Queue<int[]> q = new LinkedList<>();
        visited[0] = true;
        int visitedCount = 1;
        for (int i : listNeighbor.get(0)) {
            q.add(new int[]{0, i});
        }
        while (!q.isEmpty()) {
            int[] edge = q.remove();
            int start = edge[0], end = edge[1];
            if (visited[end] == true) {
                return false;
            } else {
                visited[end] = true;
                ++visitedCount;
                for (int i : listNeighbor.get(end)) {
                    if (i != start) {
                        q.add(new int[]{end, i});
                    }
                }
            }
        }
        return visitedCount == n;
    }
    
    private List<List<Integer>> getListNeighbors(int n, int[][] edges) {
        List<List<Integer>> listNeighbor = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; ++i) {
            listNeighbor.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; ++i) {
            int start = edges[i][0], end = edges[i][1];
            listNeighbor.get(start).add(end);
            listNeighbor.get(end).add(start);
        }
        return listNeighbor;
    }
}
