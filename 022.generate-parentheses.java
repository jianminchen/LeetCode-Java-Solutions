/**
 * @see <a href="https://leetcode.com/problems/generate-parentheses/">Generate Parentheses</a>
 */

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfsHelper(0, 0, new StringBuilder(), n, res);
        return res;
    }
    private void dfsHelper(int lCount, int rCount, StringBuilder path, int n, List<String> res) {
        if (lCount < rCount || lCount > n || rCount > n) return;
        if (lCount == rCount) {
            if (lCount == n) {
                res.add(new String(path));
            } else { // only can add left parenthesis
                path.append('(');
                dfsHelper(lCount + 1, rCount, path, n, res);
                path.deleteCharAt(path.length() - 1);
            }
        } else if (lCount > rCount) { // can add left or right
            path.append('(');
            dfsHelper(lCount + 1, rCount, path, n, res);
            path.deleteCharAt(path.length() - 1);
            path.append(')');
            dfsHelper(lCount, rCount + 1, path, n, res);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
