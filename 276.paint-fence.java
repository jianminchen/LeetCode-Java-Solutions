/**
 * @see <a href="https://leetcode.com/problems/paint-fence/">Paint Fence</a>
 */

public class Solution {
    public int numWays(int n, int k) {
        if (n == 0 || k == 0) return 0;
        if (n == 1) return k;
        if (n == 2) return k * k;
        int[] num = new int[n];
        num[0] = k;
        num[1] = k * k;
        for (int i = 2; i < n; i ++) {
            num[i] = (k - 1) * (num[i - 1] + num[i - 2]);
        }
        return num[n - 1];
}
