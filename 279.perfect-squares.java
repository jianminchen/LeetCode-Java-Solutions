/**
 * @see <a href="https://leetcode.com/problems/perfect-squares/">Perfect Squares</a>
 */

public class Solution {
    public int numSquares(int n) {
        int num[] = new int[n];
        for (int i = 1; i <= n; ++i) {
            num[i - 1] = i;
        }
        
        for (int i = 2; i <= n; ++i) {
            int j = 1;
            for (; j < i / j; ++j) {
                num[i-1] = Math.min(num[i - j * j - 1] + 1, num[i - 1]);
            }
            if (i == j * j) num[i - 1] = 1;
        }
        return num[n - 1];
    }
}
