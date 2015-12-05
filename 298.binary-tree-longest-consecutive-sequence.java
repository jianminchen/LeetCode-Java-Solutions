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
        Stack<Integer> lenStk = new Stack<Integer>();
        TreeNode cur = root;
        int maxLen = 0;
        while (true) {
            while (cur != null) {
                // only modify len when pushing is not enough.
                if (stk.isEmpty() || cur.val != stk.peek().val + 1) {
                    len = 1;
                }
                else { // !stk.isEmpty() && cur.val = stk.peek().val + 1
                    len = lenStk.peek() + 1;
                }
                // how can you forget this line??????????????!!!!!!!!!!!!!!!!!
                stk.push(cur);
                lenStk.push(len);
                maxLen = Math.max(maxLen, len);
                cur = cur.left;
            }
            if (stk.isEmpty()) break;
            if (stk.peek().right != null) cur = stk.peek().right;
            else {
                do {
                    cur = stk.pop();
                    lenStk.pop();
                } while (!stk.isEmpty() && (stk.peek().right == null || stk.peek().right == cur));
                if (stk.isEmpty()) break;
                else cur = stk.peek().right;
            }
        }
        return maxLen;
    }
}
