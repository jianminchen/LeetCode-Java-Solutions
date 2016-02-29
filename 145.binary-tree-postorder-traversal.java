/**
 * @see <a href="https://leetcode.com/problems/binary-tree-postorder-traversal/">Binary Tree Postorder Traversal</a>
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        Stack<TreeNode> stk = new Stack<>();
        while (true) {
            while (cur != null) {
                stk.push(cur);
                cur = cur.left;
            }
            while (!stk.isEmpty() && (stk.peek().right == null || stk.peek().right == cur)){
                cur = stk.pop();
                res.add(cur.val);
            }
            if (stk.isEmpty()) break;
            else cur = stk.peek().right;
        }
        return res;
    }
}
