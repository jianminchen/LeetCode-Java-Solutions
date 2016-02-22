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
public class Solution {
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int count = 0;
        List<Integer> list = inOrder(root);
        boolean selfIsUnival = true;
        for (int i = 1; i < list.size(); ++i) {
            if (list.get(i) != list.get(i - 1)) {
                selfIsUnival = false;
                break;
            }
        }
        
        if (selfIsUnival == true) ++ count;
        count += countUnivalSubtrees(root.left);
        count += countUnivalSubtrees(root.right);
        return count;
        
    }
    
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode cur = root;
        while (true) {
            while (cur != null) {
                stk.push(cur);
                cur = cur.left;
            }
            if (stk.isEmpty()) break;
            cur = stk.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
