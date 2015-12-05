/**
 * @see <a href="https://leetcode.com/problems/lru-cache/">LRU Cache</a>
 */

public class LRUCache {
    class MyNode {
        MyNode prev;
        MyNode next;
        int key;
        int value;
        MyNode(int k, int v) {
            key = k;
            value = v;
        }
    }
    
    MyNode head;
    MyNode tail;
    Map<Integer, MyNode> hm;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = null;
        tail = null;
        hm = new HashMap<>();
    }
    
    // both get and set are considered one usage of the cache.
    public int get(int key) {
        if (hm.containsKey(key)) {
            MyNode n = hm.get(key);
            moveNodeToTail(n);
            // if n == tail, it is the last used, no need to update
            return n.value;
        }
        else return -1;
    }
    
    public void moveNodeToTail(MyNode n) {
        if (n != tail) {
            if (n == head) {
                head = head.next;
            }
            else {
                n.prev.next = n.next;
                n.next.prev = n.prev;
            }
            n.prev = tail;
            n.next = null;
            tail.next = n;
            tail = tail.next;
        }
    }
    
    public void set(int key, int value) {
        if (head == null && hm.size() < capacity) {
            head = new MyNode(key, value);
            hm.put(key, head);
            tail = head;
        }
        // existing key.
        if (hm.containsKey(key)) { // update.
            hm.get(key).value = value;
            moveNodeToTail(hm.get(key));
        }
        // new key, may need to remove old key.
        else {
            if (hm.size() == capacity) {
                hm.remove(head.key);
                head = head.next;
            }
            MyNode newNode = new MyNode(key, value);
            tail.next = newNode;
            newNode.prev = tail;
            tail = tail.next;
            hm.put(key, newNode);
        }
    }
}
