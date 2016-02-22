/**
 * @see <a href="https://leetcode.com/problems/intersection-of-two-linked-lists/">Intersection of Two Linked Lists</a>
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int lenA = 0;
        int lenB = 0;
        ListNode cur1 = headA, cur2 = headB;
        while (cur1 != null) {
            cur1 = cur1.next;
            lenA ++;
        }
        while (cur2 != null) {
            cur2 = cur2.next;
            lenB ++;
        }
        cur1 = headA; cur2 = headB;
        for (int i = 0; i < Math.abs(lenA - lenB); i++) {
            if (lenA > lenB) cur1 = cur1.next;
            else cur2 = cur2.next;
        }
        while (cur1!= null) {
            if (cur1 == cur2) return cur1;
            else {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
        }
        return null;
        
    }
}
