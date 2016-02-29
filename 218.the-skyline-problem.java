/**
 * @see <a href="https://leetcode.com/problems/the-skyline-problem/">The Skyline Problem</a>
 */

public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        if (buildings.length == 0) return res;
        int[] arrayX = new int[buildings.length * 2];
        for (int i = 0; i < buildings.length; ++i) {
            arrayX[2 * i] = buildings[i][0];
            arrayX[2 * i + 1] = buildings[i][1];
        }
        Arrays.sort(arrayX);
        List<int[]> subBuilds = new ArrayList<>();
        for (int i = 1; i < arrayX.length; ++i) {
            if (arrayX[i] != arrayX[i - 1]) {
                int[] subB = new int[3];
                subB[0] = arrayX[i - 1];
                subB[1] = arrayX[i];
                subB[2] = getHeight(subB[0], subB[1], buildings);
                subBuilds.add(subB);
            }
        }
        int i = 0;
        while (i < subBuilds.size()) {
            int start = i;
            ++i;
            while (i < subBuilds.size() && subBuilds.get(i)[2] == subBuilds.get(i-1)[2]) ++i;
            int[] point = new int[2];
            point[0] = subBuilds.get(start)[0];
            point[1] = subBuilds.get(start)[2];
            res.add(point);
        }
        int[] lastP = new int[2];
        lastP[0] = subBuilds.get(subBuilds.size() - 1)[1];
        lastP[1] = 0;
        res.add(lastP);
        return res;
    }
    public int getHeight(int low, int high, int[][] buildings) {
        int height = 0;
        for (int i = 0; i < buildings.length; ++i) {
            if (buildings[i][0] <= low && buildings[i][1] >= high) {
                height = Math.max(height, buildings[i][2]);
            }
        }
        return height;
    }
}
