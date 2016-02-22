/**
 * @see <a href="https://leetcode.com/problems/gas-station/">Gas Station</a>
 */

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int remain[] = new int[gas.length];
        int extra = 0;
        for (int i = 0; i < gas.length; ++i) {
            remain[(i + 1) % gas.length] = extra + gas[i] - cost[i];
            extra = remain[(i + 1) % gas.length];
        }
        if (remain[0] < 0) return -1;

        int minIndex = 0;
        int minRemain = remain[0];
        for (int i = 1; i < gas.length; ++i) {
            if (remain[i] < minRemain) {
                minIndex = i;
                minRemain = remain[i];
            }
        }
        return minIndex;
    }
}
