/**
 * @see <a href="https://leetcode.com/problems/path-sum/">Path Sum</a>
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
    public boolean hasPathSum(TreeNode root, int sum) {
        // method 1: recursive solution: hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        // method 2: do a preorder traversal, when a leaf is encountered, calcuate the the sum, and if equal, return true;
        // after traversaling, return false.
        TreeNode cur = root;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        int s = 0;
        while (true) {
            while (cur != null) {
                stk.push(cur);
                s += cur.val;
                // check here.
                if (cur.left == null && cur.right == null && sum == s) {
                    return true;
                }
                cur = cur.left;
            }
            while (!stk.isEmpty() && (stk.peek().right == null || stk.peek().right == cur)) {
                cur = stk.pop();
                s -= cur.val;
            }
            if (stk.isEmpty()) break;
            else cur = stk.peek().right;
        }
        return false;
    }
}
