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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        //if (root == null) return 0;
        helper(root);
        return max;
    }
    
    // the return value of this helper function is the maximum sum of the path that starts with root.
    // meanwhile, it updates the max value.
    public int helper(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        int left = helper(root.left);
        int right = helper(root.right);
        int locMax = root.val;
        if (left > 0) locMax = left + root.val;
        if (right > 0) locMax = Math.max(locMax, right + root.val);
        
        max = Math.max(left, max);
        max = Math.max(right, max);
 
        if (left <= 0 && right <= 0) max = Math.max(root.val, max);
        else if (left <= 0 && right > 0) max = Math.max(max, root.val + right);
        else if (left > 0 && right <= 0) max = Math.max(max, root.val + left);
        else if (left > 0 && right > 0) max = Math.max(max, root.val + right + left);
        
        return locMax;
    }
}
