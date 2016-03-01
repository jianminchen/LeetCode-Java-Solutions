/**
 * @see <a href="https://leetcode.com/problems/binary-tree-paths/">Binary Tree Paths</a>
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ls = new ArrayList<>();
        ArrayList<TreeNode> stk = new ArrayList<>();
        TreeNode cur = root;
        while (true) {
            while (cur != null){
                stk.add(cur);
                if (cur.left == null && cur.right == null) { // at a leaf node, we collect one result
                    ls.add(getString(stk));
                }
                cur = cur.left;
            }
            while (!stk.isEmpty() && (stk.get(stk.size() - 1).right == null || cur == stk.get(stk.size() - 1).right)) {
                cur = stk.remove(stk.size() - 1);
            }
            if (stk.isEmpty()) break;
            else cur = stk.get(stk.size() - 1).right;
        }
        return ls;
    }
    
    private String getString(ArrayList<TreeNode> stk) {
        StringBuilder sb = new StringBuilder();
        sb.append(stk.get(0).val);
        for (int i = 1; i < stk.size(); ++i) {
            sb.append("->");
            sb.append(stk.get(i).val);
        }
        return sb.toString();
    }
}
