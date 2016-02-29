/**
 * @see <a href="https://leetcode.com/problems/count-complete-tree-nodes/">Count Complete Tree Nodes</a>
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int level = 1;
        TreeNode cur = root;
        while (cur.left != null) {
            cur = cur.left;
            ++level;
        }
        int count = (1 << (level - 1)) - 1; // the number of nodes above the last level.
        cur = root;
        int curLevel = 1;
        while (curLevel < level) {
            int remainLevel = level - curLevel - 1;
            TreeNode left = cur.left;
            for (int i = 0; i < remainLevel; ++i) {
                left = left.right;
            }
            if (left != null) {
                count += (1 << remainLevel);
                cur = cur.right; // left full, go to the right child.
            } else {
                cur = cur.left; // left not full, righ must be empty, thus, go to left;
            }
            ++curLevel;
        }
        if (cur != null) count += 1;
        return count;
    }
}
