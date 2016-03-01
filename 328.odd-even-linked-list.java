/**
 * https://leetcode.com/problems/odd-even-linked-list/
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
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        ListNode evenHead = head == null ? null : head.next;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            if (next == null) break;
            cur.next = next.next;
            if (cur.next == null) break;
            next.next = cur.next.next;
            
            cur = cur.next; // update cur
        }
        cur.next = evenHead;
        return head;
    }
}
