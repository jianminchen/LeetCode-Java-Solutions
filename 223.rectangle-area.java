/**
 * @see <a href="https://leetcode.com/problems/rectangle-area/">Rectangle Area</a>
 */

public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (A > E) return computeArea(E, F, G, H, A, B, C, D);
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int upper = Math.min(D, H);
        int lower = Math.max(B, F);
        int length = 0;
        if (right > left) length = right - left;
        int width = 0;
        if (upper > lower) width = upper - lower;
        
        return area1 - length*width + area2;
    }
}
