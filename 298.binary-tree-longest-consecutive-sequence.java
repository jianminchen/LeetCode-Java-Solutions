/**
 * @see <a href="https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/">Binary Tree Longest Consecutive Sequence</a>
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
    public int longestConsecutive(TreeNode root) {
        int len = 0;
        Stack<TreeNode> stk = new Stack<TreeNode>(); // stores the path from the root to the cur node.
        // this stack synchronizes with the stk, and record the consecutive length till this node
        Stack<Integer> lenStk = new Stack<Integer>();
        TreeNode cur = root;
        int maxLen = 0;
        while (true) { // preorder traversal
            while (cur != null) {
                if (stk.isEmpty() || cur.val != stk.peek().val + 1) {
                    len = 1; // the very beginning, or this node is non-consecutive with its parent
                } else {
                    len = lenStk.peek() + 1; // consecutive with its parent
                }
                stk.push(cur);
                lenStk.push(len);
                maxLen = Math.max(maxLen, len);
                cur = cur.left;
            }
            while (!stk.isEmpty() && (stk.peek().right == null || stk.peek().right == cur)){
                cur = stk.pop();
                lenStk.pop();
            }
            if (stk.isEmpty()) break;
            else cur = stk.peek().right;
        }
        return maxLen;
    }
}
