/**
 * @see <a href="https://leetcode.com/problems/implement-queue-using-stacks/">Implement Queue using Stacks</a>
 */

class MyQueue {
    // Push element x to the back of queue.
    public Stack<Integer> stk = new Stack<Integer>();
    public void push(int x) { // this specifies the content to be stored are integers!!!!!!
        stk.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        Stack<Integer> stk2 = new Stack<Integer>();
        while (!stk.isEmpty()) {
            stk2.push(stk.pop());
        }
        stk2.pop();
        while(!stk2.isEmpty()) {
            stk.push(stk2.pop());
        }
    }

    // Get the front element.
    public int peek() {
        Stack<Integer> stk2 = new Stack<Integer>();
        while (!stk.isEmpty()) {
            stk2.push(stk.pop());
        }
        int res = stk2.peek();
        while(!stk2.isEmpty()) {
            stk.push(stk2.pop());
        }
        return res;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stk.isEmpty();
    }
}
