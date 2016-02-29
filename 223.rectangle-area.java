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
        int length = right > left ? right - left : 0;
        int width = upper > lower ? upper - lower : 0;
        
        return area1 - length * width + area2; // do the minus first, to avoid integer overflow
    }
}
