/**
 * @see <a href="https://leetcode.com/problems/insertion-sort-list/">Insertion Sort List</a>
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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy  = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode end = prev.next;
        ListNode cur = end.next;
        while (cur != null) {
            // find the right location.

            if (cur.val >= end.val) {
                end = end.next;
                cur = cur.next;
            }
            else {
                ListNode after = prev;
                while (cur.val > after.next.val) {
                    after = after.next;
                }
                end.next = cur.next;
                ListNode temp = after.next;
                after.next = cur;
                cur.next = temp;
                cur = end.next;
            }
            // insert
            // consider the next node.
        }
        return dummy.next;
    }
}
