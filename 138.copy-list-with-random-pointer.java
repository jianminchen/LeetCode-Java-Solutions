/**
 * @see <a href="https://leetcode.com/problems/copy-list-with-random-pointer/">Copy List with Random Pointer</a>
 */

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode cur = head;
        Map<RandomListNode, RandomListNode> hm = new HashMap<>();
        // a map from original node to copied node
        while (cur != null) {
            if (!hm.containsKey(cur)) {
                RandomListNode newCur = new RandomListNode(cur.label);
                hm.put(cur, newCur);
            }
            if (cur.next != null && !hm.containsKey(cur.next)) {
                RandomListNode newNext = new RandomListNode(cur.next.label);
                hm.put(cur.next, newNext);
            }
            if (cur.random != null && !hm.containsKey(cur.random)) {
                RandomListNode newRand = new RandomListNode(cur.random.label);
                hm.put(cur.random, newRand);
            }
            if (cur.next != null) hm.get(cur).next = hm.get(cur.next);
            if (cur.random != null) hm.get(cur).random = hm.get(cur.random);
            cur = cur.next;
        }
        return hm.get(head);
    }
}
