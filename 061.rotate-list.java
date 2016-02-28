/**
 * @see <a href="https://leetcode.com/problems/rotate-list/">Rotate List</a>
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int i = 0;
        ListNode cur = head; 
        while (cur != null) { // get the total count of the nodes
            ++i;
            cur = cur.next;
        }
        int n = i;
        k = k % n;
        if (k == 0) return head;
        
        cur = head;
        for (int j = 1; j < n - k; ++j) {
            cur = cur.next;
        }
        ListNode secondEnd = cur;
        ListNode firstStart = cur.next;
        ListNode firstEnd = firstStart;
        while (firstEnd.next != null) firstEnd = firstEnd.next;
        
        firstEnd.next = head;
        secondEnd.next = null;
        return firstStart;
    }
}
