/**
 * @see <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">Construct Binary Tree from Preorder and Inorder Traversal</a>
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    public TreeNode buildTree(int[] preorder, int pfrom, int pto, int[] inorder, int ifrom, int ito) {
        if (pfrom > pto) return null;
        // array index out of bound ????
        if (pfrom == pto) return new TreeNode(preorder[pfrom]);
        TreeNode root = new TreeNode(preorder[pfrom]);
        int i = ifrom;
        for (; i <= ito; ++i) {
            if (inorder[i] == preorder[pfrom]) break;
        }
        // previously, used pfrom + 1, pfrom + 1 + i - ifrom, wrong !!!!!!!!! counts do not match!!
        root.left = buildTree(preorder, pfrom + 1, pfrom + i - ifrom, inorder, ifrom, i - 1);
        root.right = buildTree(preorder, pfrom + 1 + i - ifrom, pto,  inorder, i + 1, ito);
        return root;
    }
}
