/**
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 */

public class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> adjList = getAdjList(n, edges);
        int count = 0;
        int cur = -1;
        while (true) {
            cur = getAnUnvisited(cur + 1, visited);
            if (cur == n) break;
            ++count;
            helperDFS(cur, adjList, visited); // cur will have been visited, we can search from cur + 1.
        }
        return count;
    }
    
    private void helperDFS(int cur, List<List<Integer>> adjList, boolean[] visited){
        visited[cur] = true;
        for (int nb : adjList.get(cur)) {
            if (!visited[nb]) helperDFS(nb, adjList, visited);
        }
    }
    
    private List<List<Integer>> getAdjList(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; ++i) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        return adjList;
    }
    private int getAnUnvisited(int cur, boolean[] visited) {
        int i = cur;
        while (i < visited.length && visited[i]) ++i;
        return i;
    }
}
