/**
 * @see <a href="https://leetcode.com/problems/reverse-nodes-in-k-group/">Reverse Nodes in k-Group</a>
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, cur = prev.next;
        while (true) {
            int tk = 0; // get the next k nodes
            while (tk < k && cur != null) {
                ++tk;
                cur = cur.next;
            }
            if (tk != k) {
                break; // reach end before another k.
            } else {
                ListNode rCur = prev.next;
                while (rCur.next != cur) {
                    ListNode rNext = rCur.next;
                    rCur.next = rNext.next;
                    rNext.next = prev.next;
                    prev.next = rNext;
                }
                // after this, update prev, and cur.                
                prev = rCur;
            }
        }
        return dummy.next;
    }
}
