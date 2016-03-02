/**
 * @see <a href="https://leetcode.com/problems/trapping-rain-water/">Trapping Rain Water</a>
 */

public class Solution {
    public int trap(int[] height) {
        if (height == null) throw new NullPointerException();
        if (height.length == 0) return 0;
        int waters[] = new int[height.length];
        waters[0] = 0;
        // max should not be initialized as 0!
        int max = height[0];
        for (int i = 1; i < height.length; ++i) {
            waters[i] = Math.max(max - height[i], 0);
            if (height[i] > max) max = height[i];
        }
        int waters2[] = new int[height.length];
        waters2[height.length - 1] = 0;
        // max should be initialized as height[height.length - 1]
        max = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; --i) {
            waters2[i] = Math.max(max - height[i], 0);
            if (height[i] > max) max = height[i];
        }
        int total = 0;
        for(int i = 0; i < height.length; ++i) {
            total += Math.min(waters[i], waters2[i]);
        }
        return total;
    }
}
