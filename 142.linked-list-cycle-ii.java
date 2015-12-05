/**
 * @see <a href="https://leetcode.com/problems/linked-list-cycle-ii/">Linked List Cycle II</a>
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        while (slow.next != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            // previously written as fast = fast.next. what the hell are you doing?????
            fast = fast.next.next; 
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) return null;
        fast = head;
        /* the following code has error, why ???????????
        // not the reason here, reason as above: fast = fast.next; what the hell????
        // time limit exceeded: [1,2], tail connects to node index 0.
        while (true) {
            if (fast == slow) return slow;
            slow = slow.next;
            fast = fast.next;
        }*/
        System.out.println(slow.val);
        System.out.println(fast.val);
        while (true) {
            if (fast == slow) return slow;
            slow = slow.next;
            fast = fast.next;
        }
        
    }
}
