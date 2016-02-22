/**
 * @see <a href="https://leetcode.com/problems/remove-linked-list-elements/">Remove Linked List Elements</a>
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode cur = head;
        ListNode newHead = null;
	if (head == null) return null;

        if(cur.val != val) newHead = cur; // same head;
        else {
            while (cur != null && cur.val == val) cur = cur.next;
            newHead = cur;
        }
        
        if (newHead == null) return newHead;
        else {
            ListNode prev = newHead;
            cur = prev.next;
            while (cur != null) {
                if (cur.val == val) {
                    cur = cur.next;
                }
                else {
                    if (cur == prev.next) ;
                    else {
                        prev.next = cur;
                    }
                    cur = cur.next;
                    prev = prev.next;
                }
            }
            prev.next = null;
            return newHead;
        }
    }
    

}
