/**
 * @see <a href="https://leetcode.com/problems/path-sum-ii/">Path Sum II</a>
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<TreeNode> stk = new ArrayList<>();
        TreeNode cur = root;
        int pSum = 0;
        while (true) {
            while (cur != null) {
                stk.add(cur);
                pSum += cur.val;
                if (cur.left == null && cur.right == null && pSum == sum) {
                    List<Integer> aRes = getPath(stk);
                    res.add(aRes);
                }
                cur = cur.left;
            }
            while (stk.size() != 0 && (stk.get(stk.size() - 1).right == null 
                    || cur == stk.get(stk.size() - 1).right)) { // simplified.
                cur = stk.remove(stk.size() - 1);
                pSum -= cur.val;
            }
            if (stk.size() == 0) break;
            else cur = stk.get(stk.size() - 1).right;
        }
        return res;
    }
    public List<Integer> getPath(List<TreeNode> stk) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < stk.size(); ++i) {
            list.add(stk.get(i).val);
        }
        return list;
    }
}
