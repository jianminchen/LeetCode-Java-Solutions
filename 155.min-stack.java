/**
 * @see <a href="https://leetcode.com/problems/min-stack/">Min Stack</a>
 */

class MinStack {
    private Stack<Integer> stk = new Stack<Integer>(); 
    private Stack<Integer> minStk = new Stack<Integer>();
    public void push(int x) {
        stk.push(x);
        if (minStk.isEmpty() || x < minStk.peek()) {
            minStk.push(x);
        } else {
            minStk.push(minStk.peek());
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
