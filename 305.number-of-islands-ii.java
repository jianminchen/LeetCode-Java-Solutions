/**
 *  https://leetcode.com/problems/number-of-islands-ii/
 */

public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] parents = new int[m * n];
        Arrays.fill(parents, -1);
        List<Integer> res = new ArrayList<>();
        int count = 0;
        for (int[] pos : positions) {
            int cur = pos[0] * n + pos[1];
            parents[cur] = cur;
            ++count;
            for (int[] nb : getNeighbors(m, n, pos[0], pos[1])) {
                int neighbor = nb[0] * n + nb[1];
                if (parents[neighbor] != -1) {
                    int neighborRoot = find(parents, neighbor);
                    if (neighborRoot != cur) {
                        --count;
                        parents[neighborRoot] = cur; 
                    }
                }
            }
            res.add(count);
        }
        return res;
    }
    
    private int find(int[] parents, int i) {
        if (parents[i] == i) return i;
        i = parents[i];
        return find(parents, i);
    }
    
    private List<int[]> getNeighbors(int m, int n, int i, int j) {
        List<int[]> res = new ArrayList<>();
        if (i - 1 >= 0) res.add(new int[]{i - 1, j});
        if (i + 1 <= m - 1) res.add(new int[]{i + 1, j});
        if (j - 1 >= 0) res.add(new int[]{i, j - 1});
        if (j + 1 <= n - 1) res.add(new int[]{i, j + 1});
        return res;
    }
}
