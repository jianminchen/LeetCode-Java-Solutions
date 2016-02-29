/**
 * https://leetcode.com/problems/binary-tree-vertical-order-traversal/
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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        int nCols = getColumns(root);
        List<List<Integer>> rawRes = new ArrayList<>();
        for (int i = 0; i < nCols; ++i) {
            rawRes.add(new ArrayList<Integer>());
        }
        helper(root, nCols >> 1, rawRes);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nCols; ++i) {
            if (rawRes.get(i).size() != 0) {
                List<Integer> aCol = new ArrayList<>(rawRes.get(i));
                res.add(aCol);
            }
        }
        return res;
    }
    private int getColumns(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        int nLevels = 1;
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            TreeNode cur = q.remove();
            if (cur == null && !q.isEmpty()) {
                ++nLevels;
            }
            if (cur != null) {
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            } else { // cur == null
                if (!q.isEmpty()) q.add(null);
            }
        }
        return 2 * nLevels - 1;
    }
    private void helper(TreeNode root, int c, List<List<Integer>> rawRes) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> qNCol = new LinkedList<>();
        q.add(root);
        q.add(null);
        qNCol.add(c);
        while(!q.isEmpty()) {
            TreeNode cur = q.remove();
            if (cur != null) {
                int col = qNCol.remove();
                rawRes.get(col).add(cur.val);
                if (cur.left != null) {
                    q.add(cur.left);
                    qNCol.add(col - 1);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                    qNCol.add(col + 1);
                }
            } else {
                if (!q.isEmpty()) {
                    q.add(null);
                }
            }
        }
    }
}
