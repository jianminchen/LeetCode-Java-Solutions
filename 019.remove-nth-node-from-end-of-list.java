/**
 * @see <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/">Remove Nth Node From End of List</a>
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fp = head;
        for (int i = 0; i < n; ++i) {
            fp = fp.next;
        }
        if (fp == null) return head.next;
        ListNode sp = head;
        while (fp.next != null) {
            fp = fp.next;
            sp = sp.next;
        }
        sp.next = sp.next.next;
        return head;
    }
}
