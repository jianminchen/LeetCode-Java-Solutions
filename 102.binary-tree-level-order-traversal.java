/**
 * @see <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/">Binary Tree Level Order Traversal</a>
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lli = new ArrayList<List<Integer>>();
        if (root == null) return lli;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(null); // indicate the end of a level
        List<Integer> first = new ArrayList<Integer>();
        lli.add(first);
        while (!q.isEmpty()) {
            TreeNode cur = q.remove();
            if (cur != null) {
                lli.get(lli.size() - 1).add(cur.val);
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            } else { // cur == null
                if (!q.isEmpty()) {
                    List<Integer> next = new ArrayList<Integer>();
                    lli.add(next);
                    q.add(null); // use the null to separate the levels.
                }
            }
        }
        return lli;
    }
}
