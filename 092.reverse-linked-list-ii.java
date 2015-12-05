/**
 * @see <a href="https://leetcode.com/problems/reverse-linked-list-ii/">Reverse Linked List II</a>
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 1; i < m; ++i) {
            prev = prev.next;
        }
        ListNode start = prev.next;
        ListNode end = prev.next;
        for (int i = 0; i < n - m; ++i) {
            ListNode cur = end.next;
            end.next = cur.next;
            prev.next = cur;
            cur.next = start;
            // update start, end will remain unchanged
            start = prev.next;
        }
        return dummy.next;
    }
}
