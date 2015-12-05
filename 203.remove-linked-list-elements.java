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
        // the following approach: change the values, does not really "delete" the nodes!
        
        /*ListNode cur = head;
        ListNode lastVal = null;
        while (cur != null) {
            if (cur.val == val) {
                if (lastVal == null) { // not set
                    lastVal = cur;
                    cur = cur.next;
                }
                else { // already set, go to next node.
                    cur = cur.next;
                }
            }
            else // cur.val != val
            {
                if (lastVal == null) {
                    cur = cur.next;
                }
                else {
                    lastVal.val = cur.val;
                    lastVal.next = cur.next;
                    lastVal = null;
                    cur = cur.next;
                }
            }
        }
        if (lastVal == null) return head;
        
        if (lastVal == head) return null;
        else {
            ListNode prev = head;
            while(prev.next.val != val) prev = prev.next;
            prev.next = null;
        }
        return head;
        */
        
        
        // second approach, actually delete the nodes.
        ListNode cur = head;
        ListNode newHead = null;
        // before checking its value, check whether it's null first  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
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
            // don't forget this !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            prev.next = null;
            return newHead;
        }
    }
    

}
