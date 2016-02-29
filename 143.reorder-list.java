/**
 * @see <a href="https://leetcode.com/problems/reorder-list/">Reorder List</a>
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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        int i = 0;
        ListNode cur = head;
        while (cur != null) {
            ++i;
            cur = cur.next;
        }
        // total count will be i.
        cur = head;
        for (int j = 0; j < (i - 1) / 2; ++j) {
            cur = cur.next;
        }
        ListNode latter = cur.next;
        cur.next = null;
        latter = reverse(latter);
        
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode cur1 = head, cur2 = latter;
        boolean useOne = true;
        while (cur1 != null || cur2 != null) {
            if (useOne) {
                prev.next = cur1;
                cur1 = cur1.next;
            } else {
                prev.next = cur2;
                cur2 = cur2.next;
            }
            useOne = !useOne; // alternate
            prev = prev.next;
        }
    }
    
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
