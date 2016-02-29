/**
 * @see <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/">Lowest Common Ancestor of a Binary Tree</a>
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stk = new Stack<>();
        TreeNode cur = root;
        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();
        while (true) {
            while (cur != null) {
                stk.push(cur);
                if (cur == p && pPath.isEmpty()) {
                    pPath.addAll(stk);
                }
                if (cur == q && qPath.isEmpty()) {
                    qPath.addAll(stk);
                }
                if (!pPath.isEmpty() && !qPath.isEmpty()) {
                    break; // terminate the traversal when both paths have been found
                }
                cur = cur.left;
            }
            while (!stk.isEmpty() && (stk.peek().right == null || stk.peek().right == cur)) {
                cur = stk.pop();
            }
            if (stk.isEmpty()) {
                break;
            } else {
                cur = stk.peek().right;
            }
        }
        
        int i = 0;
        while (i < pPath.size() && i < qPath.size() && pPath.get(i) == qPath.get(i)) {
            ++i;
        }
        return pPath.get(i - 1);
    }
}
