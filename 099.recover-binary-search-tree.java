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
    public void recoverTree(TreeNode root) {
        TreeNode prev = new TreeNode(Integer.MIN_VALUE);
        TreeNode first = null, second = null;
        Stack<TreeNode> stk = new Stack<>();
        TreeNode cur = root;
        while (cur != null) { 
            // left child of cur is empty, according to inorder traversal, we should traverse this node now
            if (cur.left == null) {
                if (prev.val > cur.val) {
                    if (first == null) first = prev;
                    second = cur;
                }
                prev = cur;
                cur = cur.right;
            }
            else { // cur.left != null
                // find the inorder predecessor.
                TreeNode pred = cur.left;
                while (pred.right != null && pred.right != cur) 
                    pred = pred.right;
                
                if (pred.right == null) {
                    pred.right = cur;
                    cur = cur.left;
                }
                else { // pred.right = cur; visit and then restore the right pointer of pred.
                    if (prev.val > cur.val) {
                        if (first == null) first = prev;
                        second = cur;
                    }
                    pred.right = null;
                    // after that, we go to the right child of cur.
                    prev = cur;
                    cur = cur.right;
                }
            }
        }
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
