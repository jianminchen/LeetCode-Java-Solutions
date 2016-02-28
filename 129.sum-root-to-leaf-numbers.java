/**
 * @see <a href="https://leetcode.com/problems/sum-root-to-leaf-numbers/">Sum Root to Leaf Numbers</a>
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
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        TreeNode cur = root;
        List<TreeNode> stk = new ArrayList<TreeNode>();
        while (true) {
            while (cur != null) {
                stk.add(cur);
                if (cur.left == null && cur.right == null) {
                    sum += getNumber(stk);
                }
                cur = cur.left;
            }
            while (stk.size() != 0 && (stk.get(stk.size() - 1).right == null 
                    || stk.get(stk.size() - 1).right == cur))  {
                cur = stk.remove(stk.size() - 1);    
            }
            if (stk.size() == 0) break;
            else cur = stk.get(stk.size() - 1).right;
        }
        return sum;
    }
    public int getNumber(List<TreeNode> stk) {
        int num = 0;
        for (int i = 0; i < stk.size(); ++i) {
            num = num * 10 + stk.get(i).val;
        }
        return num;
    }
}
