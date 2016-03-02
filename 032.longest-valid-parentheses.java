/**
 * @see <a href="https://leetcode.com/problems/longest-valid-parentheses/">Longest Valid Parentheses</a>
 */

public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null) throw new NullPointerException();
        Stack<Integer> stkIndex = new Stack<>();
        stkIndex.push(-1);
        Stack<Character> stk = new Stack<>();
        int maxLen = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                stk.push('(');
                stkIndex.push(i);
            } else { // s.charAt(i) == ')'
                if (stk.isEmpty() || stk.peek() == ')') {
                    stk.push(')');
                    stkIndex.push(i);
                } else { // stk not empty, and stk.peek() == '('
                    stk.pop();
                    stkIndex.pop();
                    maxLen = Math.max(maxLen, i - stkIndex.peek());
                }
            }
        }
        return maxLen;
    }
}
