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
        // method 1 : recursive solution:
        // method 2: inorder traversal, then, binary search to find the closest value.
        if (root.left == null && root.right == null) return root.val;
        else if (root.left == null && root.right != null || 
                 root.right != null && target >= root.val) {
            if (target <= root.val) return root.val;
            else {
                int smallest = getSmallest(root.right);
                if (target - root.val < smallest - target) return root.val;
                else if (target <= smallest) {
                    return smallest;
                }
                else {
                    return closestValue(root.right, target);
                }
            }
        }
        else // if (root.right == null && root.left != null) 
        {
            if (target >= root.val) return root.val;
            else {
                int greatest = getGreatest(root.left);
                if (root.val - target <= target - greatest) {
                    return root.val;
                }
                else if (greatest <= target) {
                    return greatest;
                }
                else {
                    return closestValue(root.left, target);
                }
            }
        }
        
    }
    public int getGreatest(TreeNode root) {
        TreeNode cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        return cur.val;
    }
    public int getSmallest(TreeNode root) {
        TreeNode cur = root;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur.val;
    }
}
