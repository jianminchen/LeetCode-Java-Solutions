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
        
        // merge the two sorted list.
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy, cur1 = head, cur2 = secondHead;
        while (cur1 != null || cur2 != null) {
            if (cur1 == null || (cur2 != null && cur1.val > cur2.val)) {
                prev.next = cur2;
                cur2 = cur2.next;
            } else {
                prev.next = cur1;
                cur1 = cur1.next;
            }
            prev = prev.next;
        }
        return dummy.next;
    }
}
