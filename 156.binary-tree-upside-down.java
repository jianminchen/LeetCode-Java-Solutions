/**
 * @see <a href="https://leetcode.com/problems/binary-tree-upside-down/">Binary Tree Upside Down</a>
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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (null == root) return null;
        TreeNode cur = root;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        while (cur != null) {
            stk.push(cur);
            cur = cur.left;
        }
        TreeNode newRoot = stk.peek();
        while (stk.size() > 1) {
            TreeNode n = stk.pop();
            n.left = stk.peek().right;
            n.right = stk.peek();
        }
        stk.peek().left = null;
        stk.peek().right = null;
        return newRoot;
    }
}
