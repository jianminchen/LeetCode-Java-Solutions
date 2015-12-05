/**
 * @see <a href="https://leetcode.com/problems/reverse-linked-list/">Reverse Linked List</a>
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
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur;
            // cur should be updated before temp.next is updated !!!!!!!!!!!!!!!!
            cur = cur.next;
            temp.next = newHead;
            newHead = temp;
            // cur should be updated before temp.next is updated !!!!!!!!!!!!!!!!
            // cur = cur.next;
        }
        return newHead;
    }
}
