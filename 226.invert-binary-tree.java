/**
 * @see <a href="https://leetcode.com/problems/invert-binary-tree/">Invert Binary Tree</a>
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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        return root;
    }
}
