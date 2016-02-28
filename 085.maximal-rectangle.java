/**
 * @see <a href="https://leetcode.com/problems/maximal-rectangle/">Maximal Rectangle</a>
 */

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null) throw new NullPointerException();
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int[] height = new int[matrix[0].length];
        for (int j = 0; j < matrix[0].length; ++j) {
            int k = 0;
            while (k < matrix.length && matrix[k][j] == '1') {
                ++height[j];
                ++k;
            }
        }
        int maxArea = largestRectangleArea(height);
        for (int i = 1; i < matrix.length; ++i) {
            int[] nextHeight = new int[matrix[0].length];
            for (int j = 0; j < matrix[0].length; ++j) {
                if (height[j] >= 2) {
                    nextHeight[j] = height[j] - 1;
                } else {
                    int k = i;
                    while (k < matrix.length && matrix[k][j] == '1') {
                        ++nextHeight[j];
                        ++k;
                    }
                }
            }
            int area = largestRectangleArea(nextHeight);
            if (area > maxArea) maxArea = area;
            height = nextHeight;
        }
        return maxArea;
    }
    
    private int largestRectangleArea(int[] height) {
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
