/**
 * @see <a href="https://leetcode.com/problems/largest-rectangle-in-histogram/">Largest Rectangle in Histogram</a>
 */

public class Solution {
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
