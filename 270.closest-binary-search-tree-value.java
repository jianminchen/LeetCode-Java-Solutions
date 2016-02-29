/**
 * @see <a href="https://leetcode.com/problems/closest-binary-search-tree-value/">Closest Binary Search Tree Value</a>
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
    public int closestValue(TreeNode root, double target) {
        TreeNode upper = null, lower = null;
        TreeNode cur = root;
        // go down towards the leaf, set the upper bound and lower bound for the target when possible.
        while (cur != null) {
            if (cur.val < target) {
                lower = cur;
                cur = cur.right;
            } else {
                upper = cur;
                cur = cur.left;
            }
        }
        if (upper == null || (lower != null && target - lower.val < upper.val - target)) return lower.val;
        else return upper.val;
    }
}
