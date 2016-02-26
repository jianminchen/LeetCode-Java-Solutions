/**
 * @see <a href="https://leetcode.com/problems/lru-cache/">LRU Cache</a>
 */

public class LRUCache {
  class ListNode {
    int key, val;
    ListNode prev, next;
    ListNode(int k, int v) {
      key = k;
      val = v; 
      prev = null;
      next = null;
    }
  }

  private int capacity, size;
  private ListNode dummyHead, dummyTail;
  private Map<Integer, ListNode> map;
  
  public LRUCache(int capacity) {
    if (capacity <= 0) {
      throw new IllegalArgumentException("Positive capacity required.");
    }
    this.capacity = capacity;
    size = 0;
    dummyHead = new ListNode(0, 0);
    dummyTail = new ListNode(0, 0);
    dummyTail.prev = dummyHead;
    dummyHead.next = dummyTail;
    map = new HashMap<Integer, ListNode>();
  }

  public int get(int key) {
    if (!map.containsKey(key)) {
      return -1;
    }
    ListNode target = map.get(key);
    remove(target);
    addToLast(target);
    return target.val;
  }

  public void set(int key, int value) {
    if (map.containsKey(key)) { // update old value of the key
      ListNode target = map.get(key);
      target.val = value;
      remove(target);
      addToLast(target);
    } else { // insert new key value pair, need to check current size
      if (size == capacity) {
        map.remove(dummyHead.next.key);
        remove(dummyHead.next);
        --size;
      }
      ListNode newNode = new ListNode(key, value);
      map.put(key, newNode);
      addToLast(newNode);
      ++size;
    }
  }

  private void addToLast(ListNode target) {
    target.next = dummyTail;
    target.prev = dummyTail.prev;
    dummyTail.prev.next = target;
    dummyTail.prev = target;
  }

  private void remove(ListNode target) {
    target.next.prev = target.prev;
    target.prev.next = target.next;
  }
}
