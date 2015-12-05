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
        List<TreeNode> stk = new ArrayList<TreeNode>();
        TreeNode cur = root;

        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();
        while (true) {
            while (cur != null) {
                stk.add(cur);
                if (cur == p && pPath.isEmpty()) {
                    pPath.addAll(stk);
                }
                if (cur == q && qPath.isEmpty()) {
                    qPath.addAll(stk);
                }
                if (!pPath.isEmpty() && !qPath.isEmpty()) {
                    break;
                }
                cur = cur.left;
            }
            if (stk.size() == 0) break;
            // ArrayList does not have removeLast, getLast methods!!!!!!!!!!!
            if (stk.get(stk.size() - 1).right != null) {
                cur = stk.get(stk.size() - 1).right;
            }
            else {
                do {
                    cur = stk.remove(stk.size() - 1);
                } while (stk.size() != 0 && (stk.get(stk.size() - 1).right == null || stk.get(stk.size() - 1).right == cur));
                if (stk.size() == 0) break;
                else cur = stk.get(stk.size() - 1).right;
            }
        }
        
        int i = 0;
        while (i < pPath.size() && i < qPath.size() && pPath.get(i) == qPath.get(i)) ++i;
        return pPath.get(i - 1);
        
    }
}
