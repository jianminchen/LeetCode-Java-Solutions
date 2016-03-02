/**
 * @see <a href="https://leetcode.com/problems/unique-binary-search-trees/">Unique Binary Search Trees</a>
 */

public class Solution {
    public int numTrees(int n) {
        if (1 == n) return 1;
        int nums[] = new int[n];
        nums[0] = 1;
        for (int i = 1; i <= n - 1; ++i) {
            int n1 = 2 * nums[i - 1]; // first as root and last as root;
            nums[i] = n1;
            for (int j = 1; j <= i - 1; ++j) {
                nums[i] += nums[j - 1] * nums[i - j - 1];
            }
        }
        return nums[n - 1];
    }
}
