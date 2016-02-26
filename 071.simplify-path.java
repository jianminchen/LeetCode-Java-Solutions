/**
 * @see <a href="https://leetcode.com/problems/simplify-path/">Simplify Path</a>
 */

public class Solution {
  public String simplifyPath(String path) {
    if (path == null) {
      throw new NullPointerException();
    }
    List<String> stk = new ArrayList<>();
    int idx = 0;
    while (idx < path.length()) {
      int start = idx;
      while (idx < path.length() && path.charAt(idx) != '/') {
        ++idx;
      }
      String token = path.substring(start, idx);
      if (token.equals("") || token.equals(".")) {}
      else if (token.equals("..")) {
        if (stk.size() != 0) {
          stk.remove(stk.size() - 1);
        }
      } else {
        stk.add(token);
      }
      ++idx;
    }
    if (stk.size() == 0) {
      return "/";
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < stk.size(); ++i) {
      sb.append("/");
      sb.append(stk.get(i));
    }
    return new String(sb);
  }
}
