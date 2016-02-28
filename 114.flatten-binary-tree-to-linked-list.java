/**
 * @see <a href="https://leetcode.com/problems/flatten-binary-tree-to-linked-list/">Flatten Binary Tree to Linked List</a>
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
    public void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return;
        if (root.left == null) {
            flatten(root.right);
        } else {
            flatten(root.left);
            TreeNode cur = root.left;
            while (cur.right != null) {
                cur = cur.right;
            }
            flatten(root.right);
            TreeNode temp = root.right;
            root.right = root.left;
            // need to set root.left to null.
            root.left = null;
            cur.right = temp;
        }
    }
}
