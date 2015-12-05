/**
 * @see <a href="https://leetcode.com/problems/unique-binary-search-trees-ii/">Unique Binary Search Trees II</a>
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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n <= 0) { 
            // wrong answer for input n = 0.
            // output : []
            // expected: [[]] ????????????
            // return res;
            TreeNode root = null;
            res.add(root);
            return res;
        }
        return generateTrees(1, n);
    }
    public List<TreeNode> generateTrees(int i, int j) {
        List<TreeNode> list = new ArrayList<>();
        if (i == j) {
            TreeNode n = new TreeNode(i);
            list.add(n);
            return list;
        }
        // first node as root
        for(TreeNode n : generateTrees(i + 1, j)) {
            TreeNode root = new TreeNode(i);
            root.right = n;
            list.add(root);
        }
        
        
        // last node as root
        for (TreeNode n : generateTrees(i, j - 1)) {
            TreeNode root = new TreeNode(j);
            root.left = n;
            list.add(root);
        }
        
        // middle nodes as root;
        for (int k = i + 1; k <= j - 1; ++k) {
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
