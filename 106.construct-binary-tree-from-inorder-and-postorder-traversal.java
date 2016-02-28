/**
 * @see <a href="https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/">Construct Binary Tree from Inorder and Postorder Traversal</a>
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) return null;
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    public TreeNode buildTree(int[] inorder, int ifrom, int ito, int[] postorder, int pfrom, int pto) {
        if (ifrom > ito) return null;
        if (ifrom == ito) {
            return new TreeNode(inorder[ifrom]);
        }
        int i = ifrom;
        for (; i <= ito; ++i) {
            if (inorder[i] == postorder[pto]) break;
        }
        // i is the location that separate the two subtrees.
        root.left = buildTree(inorder, ifrom, i - 1, postorder, pfrom, pfrom + (i - 1  - ifrom));
        root.right = buildTree(inorder, i + 1, ito, postorder, pfrom + (i  - ifrom), pto - 1);
        return root;
    }
}
