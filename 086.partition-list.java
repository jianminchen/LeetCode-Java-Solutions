/**
 * @see <a href="https://leetcode.com/problems/partition-list/">Partition List</a>
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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode smallEnd = dummy;
        while (smallEnd.next != null && smallEnd.next.val < x) smallEnd = smallEnd.next;
        ListNode greatStart = smallEnd.next;
        if (greatStart == null) return dummy.next;
        ListNode greatEnd = greatStart;
        while (greatEnd.next != null && greatEnd.next.val >= x) greatEnd = greatEnd.next;
        
        ListNode cur = greatEnd.next;
        while (cur != null) {
            ListNode nextSmallStart = cur;
            while (cur.next != null && cur.next.val < x) cur = cur.next;
            ListNode nextSmallEnd = cur;
            ListNode nextGreatStart = cur.next;
            smallEnd.next = nextSmallStart;
            nextSmallEnd.next = greatStart;
            greatEnd.next = nextGreatStart;
            
            // update smallEnd, greatEnd.
            smallEnd = nextSmallEnd;
            while (greatEnd.next != null && greatEnd.next.val >= x) greatEnd = greatEnd.next;
            cur = greatEnd.next;
        }
        return dummy.next;
    }
}
