/**
 * @see <a href="https://leetcode.com/problems/kth-smallest-element-in-a-bst/">Kth Smallest Element in a BST</a>
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
    public int kthSmallest(TreeNode root, int k) {
        int i = 0;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode cur = root;
        while (true) {
            while (cur != null) {
                stk.push(cur);
                cur = cur.left;
            }
            if (stk.isEmpty()) break;
            cur = stk.pop();
            ++i;
            if (i == k) break;
            cur = cur.right;
        }
        return cur.val;
    }
}
