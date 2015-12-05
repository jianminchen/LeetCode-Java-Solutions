/**
 * @see <a href="https://leetcode.com/problems/binary-search-tree-iterator/">Binary Search Tree Iterator</a>
 */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    Stack<TreeNode> stk;
    // TreeNode cur;
    public BSTIterator(TreeNode root) {
        stk = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null) {
            stk.push(cur);
            cur = cur.left;
        }
        // if (stk.isEmpty()) cur = null;
        // else cur = stk.peek();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stk.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {

        /* the following is wrong !!!!!!!1
        do {
            cur = stk.pop();
        } while (!stk.isEmpty() && (stk.peek().right == null || stk.peek().right == cur));
        */
        TreeNode cur = stk.pop();
        int returnValue = cur.val;
        if (cur.right != null) {
            cur = cur.right;
            while (cur != null) {
                stk.push(cur);
                cur = cur.left;
            }
        }
        else {
            ;
        }
        // if (!stk.isEmpty()) cur = stk.peek();
        return returnValue;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
