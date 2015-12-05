/**
 * @see <a href="https://leetcode.com/problems/swap-nodes-in-pairs/">Swap Nodes in Pairs</a>
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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev != null && prev.next != null && prev.next.next != null) {
            ListNode cur = prev.next;
            ListNode next = prev.next.next;
            cur.next = next.next;
            next.next = cur;
            prev.next = next;
            prev = prev.next.next;
        }
        return dummy.next;
    }
}
