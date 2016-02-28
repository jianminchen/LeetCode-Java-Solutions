/**
 * @see <a href="https://leetcode.com/problems/binary-tree-right-side-view/">Binary Tree Right Side View</a>
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            if (node != null) {
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
                if (q.peek() == null) res.add(node.val); // it is the last one in this level.
            } else { // the removed node is null, we are finishing the traversal of the current level
                if (q.isEmpty()) break;
                else q.add(null);
            }
        }
        return res;
    }
}

// testcases: how can you forget the most special test case ???  root == null ???
// 1. single node.
// 2. root and only left child.
// 3. root and only right child.
// 4.
//        0
//       /
//      0
//     /
//    0
