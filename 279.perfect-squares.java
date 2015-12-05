/**
 * @see <a href="https://leetcode.com/problems/perfect-squares/">Perfect Squares</a>
 */

public class Solution {
    public int numSquares(int n) {
        int num[] = new int[n];
        num[0] = 1;
        for (int i = 2; i <= n; ++i) {
            num[i - 1] = n;
        }
        
        for (int i = 2; i <= n; ++i) {
            // num[i - 1] will be the min num for i.
            int j = 1;
            for (; j < i / j; ++j) {
                num[i-1] = Math.min(num[i - j * j - 1] + 1, num[i - 1]);
            } // if you want to use j outside of for, define it outside !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            if (i == j * j) num[i - 1] = 1;
        }
        return num[n - 1];
    }
}
