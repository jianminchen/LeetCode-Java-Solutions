/**
 * @see <a href="https://leetcode.com/problems/simplify-path/">Simplify Path</a>
 */

public class Solution {
    public String simplifyPath(String path) {
        if (path.length() == 0 || path.length() == 1) return path;
        Stack<String> stk = new Stack<String>();
        int i = 0; // the index for the next '/'
        while (i < path.length()) {
            while (i <path.length() && path.charAt(i) == '/') ++i;
            int start = i - 1;
            while (i < path.length() && path.charAt(i) != '/') ++i;
            String subPath = path.substring(start, i);
            if (!subPath.equals("/.")) {
                if (subPath.equals("/..")) {
                    if (stk.isEmpty()) stk.push("/");
                    else if (stk.size() == 1) {
                        stk.pop();
                        stk.push("/");
                    }
                    else stk.pop();
                }
                else {
                    if (stk.size() == 1 && stk.peek().equals("/")) stk.pop(); 
                    stk.push(subPath);
                }
            }
            else {
                if (stk.isEmpty()) stk.push("/");
            }
        }
        if (stk.size() > 1 && stk.peek().equals("/")) stk.pop();
        String res = new String();
        while (!stk.isEmpty()) {
            res = stk.pop() + res;
        }
        return res;
    }
}
