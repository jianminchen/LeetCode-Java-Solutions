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
    /*
    public boolean isBalanced(TreeNode root) {
        // left tree is balanced, right tree is balanced, heights do not differ more than 1.
        if (root == null) return true;
        if (!isBalanced(root.left)) return false;
        if (!isBalanced(root.right)) return false;
        if (Math.abs(treeHight(root.left) - treeHight(root.right)) > 1) return false;
        return true;
    }
    public int treeHight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(treeHight(root.left), treeHight(root.right));
    }
    */
    // the above solution has stack overflow error. 
    
    
    // calculate the height of each node first, store the height of each node in a hashmap for constant access.
    // do a post order traversal to calculate the height.
    HashMap<TreeNode, Integer> hm;
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        hm = new HashMap<TreeNode, Integer>();
        calculateHeight(root); // do a postOrder traversal to calculate the height of all nodes.
        return myIsBalanced(root);
    }
    public boolean myIsBalanced(TreeNode root) {
        if (root == null) return true; // don't forget this !!!!!!!!!!!!!!!!!!!!!!!!!
        //if (root.left == null && root.right == null) return true;
        //if (root.left == null && root.right != null) return root.right.left == null && root.right.right == null;
        //if (root.left != null && root.right == null) return root.left.left == null && root.left.right == null;
        
        if (!myIsBalanced(root.left)) return false;
        if (!myIsBalanced(root.right)) return false;
        if (Math.abs(hm.get(root.left) - hm.get(root.right)) > 1) return false; // the height of null is not defined!!!!!!!!!!!!!!!!!!!!
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
            // previously written as follows, wrong !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!11
            /*
            while (cur.left != null) {
                stk.push(cur);
                cur = cur.left;
            }            
            */
            if (stk.isEmpty()) break;
            TreeNode top = stk.peek();
            if (top.right != null) {
                cur = top.right;
            }
            else {
                /*
                cur = stk.pop();
                while (!isEmpty() && (stk.peek().right == null || cur == stk.peek().right) {
                    cur = stk.pop();
                }
                */
                do {
                    cur = stk.pop();
                    // calculate the height of the node;
                    // hashmap can put null as key; we can make use of this
                    //if (cur.left == null && cur.right == null) hm.put(cur, 1);
                    //else if (cur.left != null && cur.right == null) hm.put(cur, Math.max(1, 1 + hm.get(cur.left)));
                    //else if (cur.left == null && cur.right != null) hm.put(cur, Math.max(1, 1 + hm.get(cur.right)));
                    //else hm.put(cur, 1 + Math.max(hm.get(cur.left), hm.get(cur.right)));
                    hm.put(cur, 1 + Math.max(hm.get(cur.left), hm.get(cur.right)));
                } while (!stk.isEmpty() && (stk.peek().right == null || cur == stk.peek().right));
                
                if (stk.isEmpty()) break;
                else cur = stk.peek().right;
            }
        }
    }
}
