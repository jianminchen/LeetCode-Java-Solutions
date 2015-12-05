/**
 * @see <a href="https://leetcode.com/problems/binary-tree-level-order-traversal-ii/">Binary Tree Level Order Traversal II</a>
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // the key is how to determine which level does each node belong to.
        // approach 1: use a queue to record the level number of the node, when enqueue it.
        // approach 2: when we come to an end of one level, we enqueue a null node to seperate different levels.
        List<List<Integer>> lli = new ArrayList<List<Integer>>();
        List<Integer> li = new ArrayList<Integer>();
        // question: what should be returned when root is null !!!!!!!!!!????????????????
        // return lli directly, or after it adds an empty li ?????????????????????????
        /// return lli directly, otherwise, wrong answer !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        if (root == null) {
            // lli.add(li);
            return lli;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);
        List<Integer> first = new ArrayList<Integer>();
        // first.add(root.val);
        lli.add(first); // we need to do some initialization before we enter the loop.
        
        TreeNode cur = null;
        while (!q.isEmpty()) {
            cur = q.remove();
            if (cur == null && !q.isEmpty()) {
                List<Integer> aList = new ArrayList<Integer>();
                lli.add(aList);
                q.add(null);
            }
            else {
                if (cur == null) {
                    break; // q.isEmpty() here !!!!!!!!!!!!!!!!!!!!!!!!
                }
                lli.get(lli.size() - 1).add(cur.val);
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
        }
        
        // reverse to make it bottom-up.
        for (int i = 0; i < lli.size()/2; i ++) { // previously, written as i < lli.size(); wrong !!!!!!!!!!!!!!!!!!111
                                                 // for reverse, we only need to go from 0 to the middle point.
            List<Integer> temp = lli.get(i);
            lli.set(i, lli.get(lli.size() - 1 - i));
            lli.set(lli.size() - 1 - i, temp);
        }
        return lli;
    }
}
