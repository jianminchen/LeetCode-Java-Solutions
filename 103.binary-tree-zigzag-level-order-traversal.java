/**
 * @see <a href="https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/">Binary Tree Zigzag Level Order Traversal</a>
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> firstList = new ArrayList<>();
        res.add(firstList);
        q.add(root);
        q.add(null); // to indicate the end of a level
        while (!q.isEmpty()) {
            TreeNode n = q.remove();
            if (q.isEmpty()) {
                break;
            } else {
                if (n == null) {
                    List<Integer> newList = new ArrayList<>();
                    res.add(newList);
                    q.add(null);
                } else { // n is a node
                    res.get(res.size() - 1).add(n.val); // add here
                    if (n.left != null) q.add(n.left);
                    if (n.right != null) q.add(n.right);
                }
            }
        }
        for (int i = 1; i < res.size(); i = i + 2) {
            Collections.reverse(res.get(i));
        }
        return res;
    }
}
