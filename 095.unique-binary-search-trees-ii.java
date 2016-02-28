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
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) return new ArrayList<TreeNode>();
        return generateTrees(1, n);
    }
    
    private List<TreeNode> generateTrees(int i, int j) {
        List<TreeNode> list = new ArrayList<>();
        if (i > j) {
            list.add(null);
            return list;
        }
        // using k as root;
        for (int k = i; k <= j; ++k) {
            for (TreeNode left : generateTrees(i, k - 1)) {
                for (TreeNode right : generateTrees(k + 1, j)) {
                    TreeNode root = new TreeNode(k);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
