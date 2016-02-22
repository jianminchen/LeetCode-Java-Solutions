/**
 * @see <a href="https://leetcode.com/problems/generate-parentheses/">Generate Parentheses</a>
 */

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n <= 0) return res;
        if (n == 1) {
            String s = "()";
            res.add(s);
            return res;
        }
        Stack<Integer> stk = new Stack<Integer>();
        for (int i = 0; i < n; ++i) stk.push(i);
        while (true) {
            String str = generateStringByStack(stk);
            res.add(str);
            // go forward:
            if (stk.size() - 1 >= stk.peek() + 1 - (stk.size() - 1))
                stk.push(stk.pop() + 1);

            // backtrack:
            else {
                stk = backtrack(stk);
            }
            if (stk.isEmpty()) break;
        }
        return res;
    }
    
    public String generateStringByStack(Stack<Integer> stk) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stk.size() * 2; ++i) {
            sb.append(')');
        }
        ArrayList<Integer> indices = new ArrayList<Integer>();
        while (!stk.isEmpty()) {
            indices.add(stk.pop());
        }
        for (int i = indices.size() - 1; i >= 0; --i) {
            stk.push(indices.get(i));
            sb.setCharAt(indices.get(i), '(');
        }
        return new String(sb);
    }
    
    public Stack<Integer> backtrack(Stack<Integer> stk) {
        int popCount = 0;
        while (!stk.isEmpty() && stk.size() - 1 < stk.peek() + 1 - (stk.size() - 1)) {
                stk.pop();
                ++popCount;
        }
        if (stk.isEmpty()) return stk;
        stk.push(stk.pop() + 1);
        for (int i = 0; i < popCount; ++i) {
            stk.push(stk.peek() + 1);
        }
        return stk;
    }
}
