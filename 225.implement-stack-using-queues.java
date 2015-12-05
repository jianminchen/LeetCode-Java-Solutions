/**
 * @see <a href="https://leetcode.com/problems/implement-stack-using-queues/">Implement Stack using Queues</a>
 */

class MyStack {
    /* the following logic is wrong !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // Push element x onto stack.
    Queue<Integer> pushQ = new LinkedList<Integer>();
    Queue<Integer> popQ = new LinkedList<Integer>();
    public void push(int x) {
        pushQ.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (popQ.isEmpty()) {
            ArrayList<Integer> al = new ArrayList<Integer>();
            while (!pushQ.isEmpty()) {
                al.add(pushQ.remove());
            }
            for (int i = al.size() - 1; i >= 0; i --) {
                popQ.add(al.get(i));
            }
        }
        popQ.remove();
    }

    // Get the top element.
    public int top() {
        if (popQ.isEmpty()) {
            ArrayList<Integer> al = new ArrayList<Integer>();
            while (!pushQ.isEmpty()) {
                al.add(pushQ.remove());
            }
            for (int i = al.size() - 1; i >= 0; i --) {
                popQ.add(al.get(i));
            }
        }
        return popQ.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return pushQ.isEmpty() && popQ.isEmpty();
    }
    */
    
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
