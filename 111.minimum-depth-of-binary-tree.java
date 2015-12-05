/**
 * @see <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree/">Minimum Depth of Binary Tree</a>
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
    public int minDepth(TreeNode root) {
        /* the following solution is wrong, for input [1, 2], it outputs 1, but 2 is expected.
        if (root == null) return 0;
        else return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        */
        if (root == null) return 0;
        if (root.left == null)
            return 1 + minDepth(root.right);
        else if (root.right == null) {
            return 1 + minDepth(root.left);
        }
        else 
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
