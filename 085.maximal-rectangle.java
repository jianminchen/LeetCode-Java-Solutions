/**
 * @see <a href="https://leetcode.com/problems/maximal-rectangle/">Maximal Rectangle</a>
 */

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
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
                if (height[j] >= 2) nextHeight[j] = height[j] - 1;
                else {
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
    public int largestRectangleArea(int[] height) {
        List<Integer> hList = new ArrayList<>();
        hList.add(0);
        for (int i = 0; i < height.length; ++i) {
            hList.add(height[i]);
        }
        hList.add(0);
        Stack<Integer> stkH = new Stack<>();
        Stack<Integer> stkI = new Stack<>();
        stkH.push(0);
        stkI.push(0);
        int maxArea = 0;
        for (int i = 1; i < hList.size(); ++i) {
            if (hList.get(i) >= stkH.peek()) {
                stkH.push(hList.get(i));
                stkI.push(i);
            }
            // if skipping hList.get(i) == stkH.peek(), wrong answer for input:
            // [0, 9]; output 18, expected 9 !!!!!!!!!!
            // else if (hList.get(i) == stkH.peek()) ;
            else { // hList.get(i) < stkH.peek();
                while (hList.get(i) < stkH.peek()) {
                    int area = 0;
                    int high = stkH.pop();
                    // wrong !! for input: 2 1 2
                    // int index = stkI.pop();
                    stkI.pop();
                    int index = stkI.peek() + 1;
                    area = high * (i - index);
                    if (area > maxArea) maxArea = area;
                }
                stkH.push(hList.get(i));
                stkI.push(i);
            }
        }
        return maxArea;
    }
}
