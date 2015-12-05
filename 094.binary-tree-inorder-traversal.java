/**
 * @see <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/">Binary Tree Inorder Traversal</a>
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode cur = root;
        while (true) {
            while (cur != null) {
                stk.push(cur);
                cur = cur.left;
            }
            if (stk.isEmpty()) break;
            cur = stk.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }
}
