/**
 * @see <a href="https://leetcode.com/problems/validate-binary-search-tree/">Validate Binary Search Tree</a>
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
    public boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        TreeNode prev = null;
        TreeNode cur = root;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        while (true) {
            while (cur != null) {
                stk.push(cur);
                cur = cur.left;
            }
            if (stk.isEmpty()) break;
            TreeNode pop = stk.pop();
            if (prev == null) {
                prev = pop;
            } else {
                if (pop.val <= prev.val) {
                    return false;
                } else {
                    prev = pop;
                }
            }
            cur = pop.right;
        }
        return true;
    }
}
