/**
 * @see <a href="https://leetcode.com/problems/merge-two-sorted-lists/">Merge Two Sorted Lists</a>
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode newL = null;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        if (l1.val <= l2.val) {
            newL = l1;
            cur1 = cur1.next;
        }
        else {
            newL = l2;
            cur2 = cur2.next;
        }
        ListNode cur = newL;
        while (true) {
            if (cur1 == null) {
                cur.next = cur2;
                break;
            }
            else if (cur2 == null) {
                cur.next = cur1;
                break;
            }
            else { // both not null;
                if (cur1.val <= cur2.val) {
                    cur.next = cur1;
                    cur1 = cur1.next;
                }
                else {
                    cur.next = cur2;
                    cur2 = cur2.next;
                }
                cur = cur.next;
            }
        }
        return newL;
        
    }
}
