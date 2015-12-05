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
        // method 1: use hashMap, easy.
        // method 2: analysis:
        //           if they intersect at some node, then, the last node of the two linked lists must be the same.
        //           so, traverse one linked list to the end to get the last node. Then, check whether the second 
        //           linkedlist has the node.
        /*
        if (headA == null || headB == null) return null;
        ListNode cur1 = headA;
        while (cur1.next != null) {
            cur1 = cur1.next;
        }
        ListNode cur2 = headB;
        while (cur2 != null) {
            if (cur1 == cur2) return cur1;
            cur2 = cur2.next;
        }
        return  null;
        */
        // the problem is to find the node if intersects, not just determine whether they intersect!!!!!!!!!!
        // Thus, get the last node is wrong !!!!!!!! Getting the last node can only be used to determine whether they are equal.
        // the above solution is all wrong.
        
        
        // the following solution used HashSet, accepted, but used O(n) memory.
        /*
        ListNode cur1 = headA;
        HashSet<ListNode> hs = new HashSet<ListNode>();
        while (cur1 != null) {
            hs.add(cur1);
            cur1 = cur1.next;
        }
        ListNode cur2 = headB;
        while (cur2 != null) {
            if (hs.contains(cur2)) return cur2;
            cur2 = cur2.next;
        }
        return null;
        */
        
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
