/**
 * @see <a href="https://leetcode.com/problems/implement-stack-using-queues/">Implement Stack using Queues</a>
 */

class MyStack {
    
    Queue<Integer> q = new LinkedList<Integer>();
    public void push(int x) {
        q.add(x); // the size of the queue is increased by one.
        for (int i = 0; i < q.size() - 1; i ++) {
            q.add(q.remove());
        }
    }    
    
    public void pop() {
        q.remove();
    }
    public int top() {
        return q.peek();
    }
    public boolean empty() {
        return q.isEmpty();
    }
}
