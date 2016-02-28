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
        TreeNode prevRight = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(prevRight);
        return root;
    }
}
