/**
 * @see <a href="https://leetcode.com/problems/balanced-binary-tree/">Balanced Binary Tree</a>
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
    HashMap<TreeNode, Integer> hm;
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        hm = new HashMap<TreeNode, Integer>();
        calculateHeight(root); // do a postOrder traversal to calculate the height of all nodes.
        return myIsBalanced(root);
    }
    public boolean myIsBalanced(TreeNode root) {
        if (root == null) return true;
        
        if (!myIsBalanced(root.left)) return false;
        if (!myIsBalanced(root.right)) return false;
        if (Math.abs(hm.get(root.left) - hm.get(root.right)) > 1) return false;
        return true;
    }
    public void calculateHeight(TreeNode root) {
        // hashmap can put null as key; we can make use of this
        hm = new HashMap<TreeNode, Integer>();
        hm.put(null, 0);
        TreeNode cur = root;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        while (true) {
            while (cur != null) {
                stk.push(cur);
                cur = cur.left;
            }
            if (stk.isEmpty()) break;
            TreeNode top = stk.peek();
            if (top.right != null) {
                cur = top.right;
            }
            else {
                do {
                    cur = stk.pop();
                    hm.put(cur, 1 + Math.max(hm.get(cur.left), hm.get(cur.right)));
                } while (!stk.isEmpty() && (stk.peek().right == null || cur == stk.peek().right));
                
                if (stk.isEmpty()) break;
                else cur = stk.peek().right;
            }
        }
    }
}
