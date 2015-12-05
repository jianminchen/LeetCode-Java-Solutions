/**
 * @see <a href="https://leetcode.com/problems/binary-tree-preorder-traversal/">Binary Tree Preorder Traversal</a>
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode cur = root;
        while (true) {
            while (cur != null) {
                stk.push(cur);
                list.add(cur.val);
                cur = cur.left;
            }
            if (stk.isEmpty()) break;
            cur = stk.pop().right;
        }
        return list;
    }
}
