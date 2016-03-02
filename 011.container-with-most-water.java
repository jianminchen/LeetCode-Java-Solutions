/**
 * @see <a href="https://leetcode.com/problems/container-with-most-water/">Container With Most Water</a>
 */

public class Solution {
    public int maxArea(int[] height) {
        if (height == null) throw new NullPointerException();
        if (height.length == 0) return 0;
        int i = 0, j = height.length - 1;
        int max = (j - i) * Math.min(height[i], height[j]);
        while (i < j) {
            if (height[i] >= height[j]) {
                --j;
            } else {
                ++i;
            }
            max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
        }
        return max;
    }
}
