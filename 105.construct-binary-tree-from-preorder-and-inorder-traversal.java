/**
 * @see <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">Construct Binary Tree from Preorder and Inorder Traversal</a>
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *   int val;
 *   TreeNode left;
 *   TreeNode right;
 *   TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder == null || inorder == null) {
      return null;
    }
    return buildTree(preorder, 0, preorder.length - 1, 
        inorder, 0, inorder.length - 1);
  }

  private TreeNode buildTree(int[] preorder, int pfrom, int pto, 
      int[] inorder, int ifrom, int ito) {
    if (pfrom > pto) {
      return null;
    }
    TreeNode root = new TreeNode(preorder[pfrom]);
    int i = ifrom;
    for (; i <= ito; ++i) {
      if (inorder[i] == preorder[pfrom]) {
        break;
      }
    }
    root.left = buildTree(preorder, pfrom + 1, pfrom + i - ifrom, 
        inorder, ifrom, i - 1);
    root.right = buildTree(preorder, pfrom + 1 + i - ifrom, pto,  
        inorder, i + 1, ito);
    return root;
  }
}
