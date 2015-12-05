/**
 * @see <a href="https://leetcode.com/problems/valid-parentheses/">Valid Parentheses</a>
 */

public class Solution {
    public boolean isValid(String s) {
        if (null == s) return true;
        Stack<Character> stk = new Stack<Character>();
        for(int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '(' || 
                s.charAt(i) == '[' || s.charAt(i) == '{')
                stk.push(s.charAt(i));
            else {
                char c = s.charAt(i);
                switch (c) {
                    case ')':
                        if (stk.isEmpty() || stk.peek() != '(') return false;
                        else stk.pop();
                        break;
                    case ']':
                        if (stk.isEmpty() || stk.peek() != '[') return false;
                        else stk.pop();
                        break;
                    case '}':
                        if (stk.isEmpty() || stk.peek() != '{') return false;
                        else stk.pop();
                }
            }
        }
        return stk.isEmpty();
    }
}
