/**
 * @see <a href="https://leetcode.com/problems/minimum-height-trees/">Minimum Height Trees</a>
 */

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> adjLists = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            List<Integer> l = new ArrayList<>();
            adjLists.add(l);
        }
        int[] nbCount = new int[n];
        Set<Integer> remain = new HashSet<>();
        for (int i = 0; i < n; ++i) remain.add(i);
        
        for (int i = 0; i < edges.length; ++i) {
            ++nbCount[edges[i][0]];
            ++nbCount[edges[i][1]];
            adjLists.get(edges[i][0]).add(edges[i][1]);
            adjLists.get(edges[i][1]).add(edges[i][0]);
        }
        int[] maxHeight = new int[n];
        int height = 0;
        while (remain.size() != 0) {
            Set<Integer> setToRemove = new HashSet<>();
            for (int i : remain) {
                // using == 1, will have tle.
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
