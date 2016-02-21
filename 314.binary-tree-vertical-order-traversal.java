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
    List<List<Integer>> rawRes;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        int nCols = getColumns(root);
        rawRes = new ArrayList<>();
        for (int i = 0; i < nCols; ++i) {
            List<Integer> al = new ArrayList<>();
            rawRes.add(al);
        }
        System.out.println(nCols);
        helper(root, nCols >> 1);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nCols; ++i) {
            if (rawRes.get(i).size() != 0) {
                List<Integer> aCol = new ArrayList<>();
                aCol.addAll(rawRes.get(i));
                res.add(aCol);
            }
        }
        return res;
    }
    public int getColumns(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        Queue<TreeNode> q = new LinkedList<>();
        int nLevels = 2;
        if (root.left != null) q.add(root.left);
        if (root.right != null) q.add(root.right);
        q.add(null);
        while (!q.isEmpty()) {
            TreeNode cur = q.remove();
            if (cur == null && !q.isEmpty()) {
                ++nLevels;
            }
            if (cur != null) {
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
            else { // cur == null
                // this if condition is a must, otherwise, time limit exceeded! endless while loop!
                if (!q.isEmpty()) q.add(null);
            }
        }
        return 2 * nLevels - 1;
    }
    // given the column number of the root, do a level order traversal and add nodes to
    // corresponding location.
    public void helper(TreeNode root, int c) {
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
            }
            else {
                // cur == null
                if (!q.isEmpty()) {
                    q.add(null);
                }
            }
        }
    }
}
