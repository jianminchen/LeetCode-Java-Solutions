/**
 * @see <a href="https://leetcode.com/problems/minimum-height-trees/">Minimum Height Trees</a>
 */

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges == null) throw new NullPointerException();
        if (n <= 0) throw new IllegalArgumentException("n must be positive.")
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> adjLists = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            adjLists.add(new ArrayList<Integer>());
        }
        int[] nbCount = new int[n];
        Set<Integer> remain = new HashSet<>();
        for (int i = 0; i < n; ++i) remain.add(i);
        // process the edges to construct adjacency list, and get neighbor count of each node
        for (int i = 0; i < edges.length; ++i) {
            ++nbCount[edges[i][0]];
            ++nbCount[edges[i][1]];
            adjLists.get(edges[i][0]).add(edges[i][1]);
            adjLists.get(edges[i][1]).add(edges[i][0]);
        }
        
        int[] maxHeight = new int[n];
        int height = 0;
        // an approach similar to topological sort.
        while (remain.size() != 0) {
            Set<Integer> setToRemove = new HashSet<>();
            for (int i : remain) {
                if (nbCount[i] <= 1) {
                    setToRemove.add(i);
                    maxHeight[i] = height;
                }
            }
            for (int i : setToRemove) {
                for (int nb : adjLists.get(i)) {
                    --nbCount[nb];
                }
            }
            ++height;
            remain.removeAll(setToRemove);
        }
        
        int min = 0;
        for (int i = 0; i < n; ++i) {
            if (min < maxHeight[i]) min = maxHeight[i];
        }
        for (int i = 0; i < n; ++i) {
            if (min == maxHeight[i]) res.add(i);
        }
        return res;
    }
}
