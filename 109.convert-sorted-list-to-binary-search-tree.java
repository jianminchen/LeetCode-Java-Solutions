/**
 * @see <a href="https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/">Convert Sorted List to Binary Search Tree</a>
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        return toBST(list, 0, list.size() - 1);
    }
    public TreeNode toBST(List<Integer> list, int low, int high) {
        if (high < low) return null;
        int mid = low + ((high - low)>>1);
        TreeNode root = new TreeNode(list.get(mid));
        root.left = toBST(list, low, mid - 1);
        root.right = toBST(list, mid + 1, high);
        return root;
    }
}
