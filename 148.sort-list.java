/**
 * @see <a href="https://leetcode.com/problems/sort-list/">Sort List</a>
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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        int i = 0;
        ListNode cur = head;
        while (cur != null) {
            ++i;
            cur = cur.next;
        }
        int count = i; // the number of nodes in the list.
        ListNode firstEnd = head;
        for (int j = 1; j < count / 2; ++j) {
            firstEnd = firstEnd.next;
        }
        ListNode secondHead = firstEnd.next;
        firstEnd.next = null;
        
        head = sortList(head); // sort first half.
        secondHead = sortList(secondHead); // sort second half.
        ListNode dummy = new ListNode(0);
        // define prev before use it.
        ListNode prev = dummy;
        ListNode cur1 = head;
        ListNode cur2 = secondHead;
        while (cur1 != null || cur2 != null) {
            // yes, some cases can be combined to make the code simple.
            if (cur1 == null || (cur1 != null && cur2 != null && cur1.val > cur2.val)) {
                prev.next = cur2;
                prev = prev.next;
                cur2 = cur2.next;
            }
            else {
                prev.next = cur1;
                prev = prev.next;
                cur1 = cur1.next;
            }
        }
        return dummy.next;
    }
}
