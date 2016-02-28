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
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode prev1 = dummy1, prev2 = dummy2;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                prev1.next = cur;
                prev1 = prev1.next;
            } else {
                prev2.next = cur;
                prev2 = prev2.next;
            }
            cur = cur.next;
        }
        prev2.next = null;
        prev1.next = dummy2.next;
        return dummy1.next;
    }
}
