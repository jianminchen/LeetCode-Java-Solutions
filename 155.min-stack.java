/**
 * @see <a href="https://leetcode.com/problems/min-stack/">Min Stack</a>
 */

class MinStack {
    Stack<Integer> stk = new Stack<Integer>(); 
    Stack<Integer> minStk = new Stack<Integer>();
    public void push(int x) {
        stk.push(x);
        if (minStk.isEmpty()) {
            minStk.push(x);
        }
        else {
            if (x < minStk.peek()) minStk.push(x);
            else minStk.push(minStk.peek());
        }
    }

    public void pop() {
        stk.pop();
        minStk.pop();
    }

    public int top() {
        return stk.peek();
    }

    public int getMin() {
        return minStk.peek();
    }
}
