/**
 * @see <a href="https://leetcode.com/problems/closest-binary-search-tree-value-ii/">Closest Binary Search Tree Value II</a>
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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<Integer> upperStk = new Stack<>();
        Stack<Integer> lowerStk = new Stack<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val < target) {
                List<Integer> list = inOrder(cur.left);
                for (int i = 0; i < list.size(); ++i) {
                    lowerStk.push(list.get(i));
                }
                lowerStk.push(cur.val);
                cur = cur.right;
            } else {
                List<Integer> list = inOrder(cur.right);
                for (int i = list.size() - 1; i >= 0; --i) {
                    upperStk.push(list.get(i));
                }
                upperStk.push(cur.val);
                cur = cur.left;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        int i = 0;
        while (i < k) {
            if (lowerStk.isEmpty() || (!upperStk.isEmpty() && upperStk.peek() - target < target - lowerStk.peek())) {
                res.add(upperStk.pop());
            } else {
                res.add(lowerStk.pop());
            }
            ++i;
        }
        return res;
    }
    
    private List<Integer> inOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        while (true) {
            while (cur != null) {
                stk.push(cur);
                cur = cur.left;
            }
            if (stk.isEmpty()) break;
            cur = stk.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }
}
