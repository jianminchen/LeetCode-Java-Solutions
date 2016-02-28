/**
 * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/">Remove Duplicates from Sorted List II</a>
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = prev.next;
        while (cur != null) {
            if (cur.next == null || cur.next.val != cur.val) {
                prev = prev.next;
                cur = cur.next;
            } else {
                int dup = cur.val;
                while (cur.next != null && cur.next.val == dup) {
                    cur = cur.next;
                }
                prev.next = cur.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
