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
        int carryIn = 0;
        ListNode cur1 = l1, cur2 = l2;
        ListNode dummy = new ListNode(0), prev = dummy;
        while (cur1 != null || cur2 != null) {
            int num1 = cur1 == null ? 0 : cur1.val;
            int num2 = cur2 == null ? 0 : cur2.val;
            int sum = carryIn + num1 + num2;
            int digit = sum % 10;
            carryIn = sum / 10;
            prev.next =  new ListNode(digit);
            prev = prev.next;
            if (cur1 != null) cur1 = cur1.next;
            if (cur2 != null) cur2 = cur2.next;
        }
        if (carryIn != 0) {
            prev.next =  new ListNode(carryIn);;
        }
        return dummy.next;
    }
}
