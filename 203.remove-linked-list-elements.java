/**
 * @see <a href="https://leetcode.com/problems/remove-linked-list-elements/">Remove Linked List Elements</a>
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0), prev = dummy;
        dummy.next = head;
        ListNode cur = head;
        while (cur != null) {
            while (cur != null && cur.val == val) cur = cur.next;
            prev.next = cur;
            prev = prev.next;
            if (cur != null) cur = cur.next;
        }
        return dummy.next;
    }
}
