/**
 * @see <a href="https://leetcode.com/problems/largest-rectangle-in-histogram/">Largest Rectangle in Histogram</a>
 */

public class Solution {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stk = new Stack<>();
        stk.push(-1); // stack of indexes. push -1 for consistency.
        int maxArea = 0;
        for (int i = 0; i < height.length; ++i) {
            while (stk.peek() != -1 && height[stk.peek()] > height[i]) {
                maxArea = Math.max(maxArea, height[stk.pop()] * (i - (stk.peek() + 1)));
            }
            stk.push(i);
        }
        while (stk.peek() != -1 && height[stk.peek()] > 0) {
            maxArea = Math.max(maxArea, height[stk.pop()] * (height.length - (stk.peek() + 1)));
        }
        return maxArea;
    }
}
