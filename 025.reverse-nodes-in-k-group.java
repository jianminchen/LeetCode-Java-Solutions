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
        // how can you forget this line ???????????????
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = prev.next;
        while (true) {
            int tk = 0; // get the next k nodes
            while (tk < k && cur != null) {
                ++tk;
                cur = cur.next;
            }
            if (tk != k) {
                break; // reach end before another k.
            }
            else {
                // reverse;
                // we have the prev, cur.
                ListNode rCur = prev.next;
                while (rCur.next != cur) {
                    ListNode rNext = rCur.next;
                    rCur.next = rNext.next;
                    // previously written as rNext = rCur!!!!!!!!!
                    // this will delete a node !!!!!!!!!!!!!!!!!!!
                    // draw some pictures to see it clearly!!!!!!!
                    // run some more cases, with at least 3 nodes, to verify the code !!!!!!!!!!
                    rNext.next = prev.next; // rNext will always be the prev's next !!!!!!!!!!!!
                    prev.next = rNext;
                }
                
                prev = rCur;
                // after this, update prev, and cur.
            }
        }
        return dummy.next;
    }
}
