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
    public boolean isBalanced(TreeNode root) {
        Map<TreeNode, Integer> heightMap = new HashMap<>();
        heightMap.put(null, 0);
        
        Stack<TreeNode> stk = new Stack<>();
        TreeNode cur = root;
        int left = 0, right = 0;
        while (true) { // determine during postorder traversal
            while (cur != null) {
                stk.push(cur);
                cur = cur.left;
            }
            while (!stk.isEmpty() && (stk.peek().right == null || stk.peek().right == cur)) {
                cur = stk.pop();
                left = heightMap.get(cur.left);
                right = heightMap.get(cur.right);
                if (Math.abs(left - right) >= 2) return false;
                heightMap.put(cur, 1 + Math.max(left, right));
            }
            if (stk.isEmpty()) break;
            else cur = stk.peek().right;
        }
        return true;
    }
}
