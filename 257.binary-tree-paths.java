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
        List<String> ls = new ArrayList<String>();
        Stack<TreeNode> stk = new Stack<TreeNode>();
        String s = new String();
        TreeNode cur = root;
        while (true) {
            while (cur != null){
                stk.push(cur);
                if (cur.left == null && cur.right == null) {
                    ls.add(getString(stk));
                }
                cur = cur.left;
            }
            if (stk.isEmpty()) break;
            cur = stk.peek();
            
            if (cur.right != null) {
                cur = cur.right;
            }
            else {
                do {
                    cur = stk.pop();
                } while (!stk.isEmpty() && (stk.peek().right == null || cur == stk.peek().right));
                if (stk.isEmpty()) break;
                else cur = stk.peek().right;
            }
        }
        return ls;
    }
    
    public String getString(Stack<TreeNode> stk) {
        if (stk.size() == 1) return (new Integer(stk.peek().val)).toString();
        ArrayList<TreeNode> al = new ArrayList<TreeNode>();
        while (!stk.isEmpty()) {
            al.add(stk.pop());
        }
        String s = new String();
        s = s + al.get(al.size() - 1).val;
        for (int i = al.size() - 2; i >= 0; i --) {
            s = s + "->" + al.get(i).val;
        }
        for (int i = al.size() - 1; i >= 0; i --) {
            stk.push(al.get(i));
        }
        return s;
    }
}
