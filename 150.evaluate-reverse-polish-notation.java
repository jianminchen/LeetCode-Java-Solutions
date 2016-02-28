/**
 * @see <a href="https://leetcode.com/problems/evaluate-reverse-polish-notation/">Evaluate Reverse Polish Notation</a>
 */

public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < tokens.length; ++i) {
            String s = tokens[i];
            // numbers can be negative, thus. this is not a correct way to determine whether it is a number or an operator.
            // if (Character.isDigit(s.charAt(0))) {
            if (Character.isDigit(s.charAt(s.length() - 1))) {
                int num = Integer.parseInt(s);
                stk.push(num);
            } else {
                char c = s.charAt(0);
                int num2 = stk.pop();
                int num1 = stk.pop();
                switch (c) {
                    case '+':
                        stk.push(num1 + num2);
                        break;
                    case '-':
                        stk.push(num1 - num2);
                        break;
                    case '*':
                        stk.push(num1 * num2);
                        break;
                    case '/':
                        stk.push(num1 / num2);
                        break;
                }
            }
        }
        return stk.pop();
    }
}
