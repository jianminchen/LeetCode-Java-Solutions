/**
 * @see <a href="https://leetcode.com/problems/add-two-numbers/">Add Two Numbers</a>
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /* normal solution without dummy
        int carryIn = 0;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode head = null;
        ListNode prev = null;
        while (cur1 != null || cur2 != null) {
            int num1 = 0;
            int num2 = 0;
            if (cur1 != null) num1 = cur1.val;
            if (cur2 != null) num2 = cur2.val;
            int sum = carryIn + num1 + num2;
            int digit = sum % 10;
            carryIn = sum / 10;
            ListNode newNode = new ListNode(digit);
            if (prev == null) {
                head = newNode;
                prev = newNode;
            }
            else {
                prev.next = newNode;
                prev = prev.next;
            }
            // how can you forget this!!!!!!!!!!!!???????????????
            // and also don't forget the null check !!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            if (cur1 != null) cur1 = cur1.next;
            if (cur2 != null) cur2 = cur2.next;
        }
        if (carryIn != 0) {
            ListNode lastNode = new ListNode(carryIn);
            prev.next = lastNode;
        }
        return head;
        */
        
        // seems a good situation to use dummy node?
        int carryIn = 0;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while (cur1 != null || cur2 != null) {
            int num1 = 0;
            int num2 = 0;
            if (cur1 != null) num1 = cur1.val;
            if (cur2 != null) num2 = cur2.val;
            int sum = carryIn + num1 + num2;
            int digit = sum % 10;
            carryIn = sum / 10;
            ListNode newNode = new ListNode(digit);
            prev.next = newNode;
            prev = prev.next;
            
            // how can you forget this!!!!!!!!!!!!???????????????
            // and also don't forget the null check !!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            if (cur1 != null) cur1 = cur1.next;
            if (cur2 != null) cur2 = cur2.next;
        }
        if (carryIn != 0) {
            ListNode lastNode = new ListNode(carryIn);
            prev.next = lastNode;
        }
        return dummy.next;        
    }
}
