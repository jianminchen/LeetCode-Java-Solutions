/**
 * @see <a href="https://leetcode.com/problems/binary-search-tree-iterator/">Binary Search Tree Iterator</a>
 */

/**
 * Definition for binary tree
 * public class TreeNode {
 *   int val;
 *   TreeNode left;
 *   TreeNode right;
 *   TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
  private Stack<TreeNode> stk;
  
  public BSTIterator(TreeNode root) {
    stk = new Stack<TreeNode>();
    TreeNode cur = root;
    while (cur != null) {
      stk.push(cur);
      cur = cur.left;
    }
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return !stk.isEmpty();
  }

  /** @return the next smallest number */
  public int next() {
    TreeNode cur = stk.pop();
    int value= cur.val;
    if (cur.right != null) {
      cur = cur.right;
      while (cur != null) {
        stk.push(cur);
        cur = cur.left;
      }
    }
    return value;
  }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
