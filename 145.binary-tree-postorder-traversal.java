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
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode cur = root;
        while (true) {
            while (cur != null) {
                stk.push(cur);
                cur = cur.left;
            }
            if (stk.isEmpty()) break;
            if (stk.peek().right != null ) cur = stk.peek().right;
            else {
                do {
                    cur = stk.pop();
                    list.add(cur.val);
                } while (!stk.isEmpty() && (stk.peek().right == null || cur == stk.peek().right));
                if (stk.isEmpty()) break;
                else cur = stk.peek().right;
            }
        }
        return list;
    }
}
