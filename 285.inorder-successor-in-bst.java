/**
 * @see <a href="https://leetcode.com/problems/inorder-successor-in-bst/">Inorder Successor in BST</a>
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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        boolean pFound = false;
        TreeNode pNext = null;
        
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode cur = root;
        while (true) {
            while (cur != null) {
                stk.push(cur);
                cur = cur.left;
            }
            if (stk.isEmpty()) break;
            cur = stk.pop();
            if (pFound) {
                pNext = cur;
                break;
            }
            if (p == cur) pFound = true;
            cur = cur.right;
        }
        return pNext;
    }
}
