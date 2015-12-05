/**
 * @see <a href="https://leetcode.com/problems/graph-valid-tree/">Graph Valid Tree</a>
 */

public class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> listNeighbor = getListNeighbors(n, edges); // use function to simplify coding.
        boolean visited[] = new boolean[n];
        // start with node zero;
        // Use a queue of edges or a queue of nodes?
        // use a queue of edges!!!!!
        // reason, every time, when we want to traverse a new edge, we need the start node of the edge to determine 
        // which edges we should add to the queue.
        // for example, if we have edges:{1, 2} and {2, 1}. we will not add {2, 1} in the queue, because we can tell it is a duplicate edge
        // but if we only use a queue of nodes, when a node is removed from the queue, we will not know the previouly node that forms an edge with the current, then, we will not know other neighbors is real duplicate node or not.
        // for example: {1, 2}, {1, 3}, {2, x}, 
        // when we remove 2, add or not add x? If add, x = 1, the output will be false, but the answer is true.
        // if not add, x = 3, the output will be true, but the answer is false.
        Queue<int[]> q = new LinkedList<>();
        visited[0] = true;
        int visitedCount = 1;
        for (int i : listNeighbor.get(0)) {
            q.add(new int[]{0, i});
        }
        while (!q.isEmpty()) {
            int[] edge = q.remove();
            int start = edge[0], end = edge[1];
            if (visited[end] == true) return false;
            else {
                visited[end] = true;
                ++visitedCount;
                for (int i : listNeighbor.get(end)) {
                    if (i != start) {
                        q.add(new int[]{end, i});
                        // do we need to or can we label i as visited here?
                        // seems no, because, next time when we remove the edge,
                        // visited[end (i)] will be true, will return false, but is not the case.
                    }
                }
            }
        }
        
        /* can increase the count during traversal, do not need to calculate again. 
        int visitedCount = 0;
        for (int i = 0; i < visited.length; ++i) {
            if (visited[i]) ++visitedCount;
        }
        */
        return visitedCount == n;
    }
    public List<List<Integer>> getListNeighbors(int n, int[][] edges) {
        List<List<Integer>> listNeighbor = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; ++i) {
            List<Integer> neighbors = new ArrayList<>();
            listNeighbor.add(neighbors);
        }
        // listNeighbor.get(i) is the list of neighbors of i.
        for (int i = 0; i < edges.length; ++i) {
            int start = edges[i][0];
            int end = edges[i][1];
            listNeighbor.get(start).add(end);
            listNeighbor.get(end).add(start);
        }
        return listNeighbor;
    }
}
