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
    public int maxPathSum(TreeNode root) {
        // the value is the maximum sum of the path from this node down to some node
        Map<TreeNode, Integer> sumMap = new HashMap<>();
        sumMap.put(null, 0);
        Stack<TreeNode> stk = new Stack<>();
        int max = Integer.MIN_VALUE;
        TreeNode cur = root;
        int left = 0, right = 0;
        while (true) {
            while (cur != null) {
                stk.push(cur);
                cur = cur.left;
            }
            while (!stk.isEmpty() && (stk.peek().right == null || stk.peek().right == cur)) {
                cur = stk.pop();
                left = sumMap.get(cur.left);
                right = sumMap.get(cur.right);
                max = Math.max(max, Math.max(left, 0) + cur.val + Math.max(right, 0));
                // if both branch are negative, we do not use them.
                sumMap.put(cur, cur.val + Math.max(0, Math.max(left, right)));
            }
            if (stk.isEmpty()) break;
            else cur = stk.peek().right;
        }
        return max;
    }
}
