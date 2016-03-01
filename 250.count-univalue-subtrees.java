/**
 * @see <a href="https://leetcode.com/problems/count-univalue-subtrees/">Count Univalue Subtrees</a>
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
// iterative postorder solution, using hashmap to record child status
public class Solution {
    public int countUnivalSubtrees(TreeNode root) {
        Map<TreeNode, Boolean> uniMap = new HashMap<>();
        TreeNode cur = root;
        Stack<TreeNode> stk = new Stack<>();
        int count = 0;
        
        while (true) {
            while (cur != null) {
                stk.push(cur);
                cur = cur.left;
            }
            while (!stk.isEmpty() && (stk.peek().right == null || stk.peek().right == cur)) {
                cur = stk.pop();
                boolean isUniVal = false;
                // four cases to consider, we can combine them to make the code simple
                if ((cur.left == null && cur.right == null)
                        || (cur.left == null && cur.right != null && uniMap.get(cur.right) && cur.val == cur.right.val)
                        || (cur.right == null && cur.left != null && uniMap.get(cur.left) && cur.val == cur.left.val)
                        || (cur.right != null && cur.left != null && uniMap.get(cur.left) && uniMap.get(cur.right)
                                && cur.val == cur.left.val && cur.val == cur.right.val)) {
                    ++count;
                    isUniVal = true;
                }
                uniMap.put(cur, isUniVal);
            }
            if (stk.isEmpty()) break;
            else cur = stk.peek().right;
        }
        return count;
    }
}
