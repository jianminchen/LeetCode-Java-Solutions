/**
 * @see <a href="https://leetcode.com/problems/merge-k-sorted-lists/">Merge k Sorted Lists</a>
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
    public class MyItem implements Comparable<MyItem> {
        public int val;
        public int i;
        public MyItem(int v, int whichList) {
            val = v;
            i = whichList;
        }
        @Override
        public int compareTo(MyItem t) {
            if (val < t.val) return -1;
            else if (val == t.val) return 0;
            else return 1;
        }
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        // O(nk) or O(nlogk);
        // how to record which list is being removed????
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        PriorityQueue<MyItem> pq = new PriorityQueue<MyItem>();
        for (int i = 0; i < lists.length; ++i) {
            if (lists[i] != null) {
                MyItem it = new MyItem(lists[i].val, i);
                pq.add(it);
            }
        }
        
        while (true) {
            if (pq.isEmpty()) break;
            MyItem r = pq.remove();
            prev.next = lists[r.i];
            lists[r.i] = lists[r.i].next;
            prev = prev.next;
            
            if (lists[r.i] != null) {
                // if previously removed item is from this list, then add the next item in this list.
                pq.add(new MyItem(lists[r.i].val, r.i));
            }
        }
        return dummy.next;
    }
}
