/**
 * @see <a href="https://leetcode.com/problems/implement-queue-using-stacks/">Implement Queue using Stacks</a>
 */

// by using two stacks, we can implement all the operations for the queue in amortized O(1)
class MyQueue {
    private Stack<Integer> pushStk = new Stack<>();
    private Stack<Integer> popStk = new Stack<>();
    // Push element x to the back of queue.
    public void push(int x) { // this specifies the content to be stored are integers
        pushStk.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (popStk.isEmpty()) {
            while (!pushStk.isEmpty()) popStk.push(pushStk.pop());
        }
        popStk.pop();
    }

    // Get the front element.
    public int peek() {
        if (popStk.isEmpty()) {
            while (!pushStk.isEmpty()) popStk.push(pushStk.pop());
        }
        return popStk.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return pushStk.isEmpty() && popStk.isEmpty();
    }
}
