/**
 * @see <a href="https://leetcode.com/problems/merge-k-sorted-lists/">Merge k Sorted Lists</a>
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *   int val;
 *   ListNode next;
 *   ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  private static class ListNodeComparator implements Comparator<ListNode> {
    @Override
    public int compare(ListNode n1, ListNode n2) {
      return n1.val - n2.val;
    }
  }

  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null) {
      throw new NullPointerException();
    }
    Queue<ListNode> pq = new PriorityQueue<>(new ListNodeComparator());
    for (int i = 0; i < lists.length; ++i) {
      if (lists[i] != null) {
        pq.add(lists[i]);
      }
    }
    ListNode dummy = new ListNode(0);
    ListNode prev = dummy;
    while (!pq.isEmpty()) {
      ListNode next = pq.remove();
      prev.next = next;
      prev = prev.next;
      if (next.next != null) {
        pq.add(next.next);
      }
    }
    return dummy.next;
  }
}
