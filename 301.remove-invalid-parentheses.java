/**
 * https://leetcode.com/problems/remove-invalid-parentheses/ 
 */ 

public class Solution {
  public List<String> removeInvalidParentheses(String s) {
    if (s == null) {
      throw new NullPointerException();
    }
    Set<String> res = new HashSet<>(); // use set to avoid duplicates
    int correctCount = getCorrectCount(s);
    dfsHelper(0, 0, new StringBuilder(), 0, s, res, correctCount);
    return new ArrayList<String>(res);
  }

  private void dfsHelper(int lCount, int rCount, StringBuilder path, 
      int start, String s, Set<String> res, int correctCount) {
    if (start == s.length()) { // we may or may not find a solution
      if (lCount == rCount && lCount == correctCount) {
        res.add(new String(path));
      }
      return; // in either case, we need to terminate
    }
    if (rCount > lCount || lCount > correctCount || rCount > correctCount) {
      return; // to terminate the dfs when possible.
    }
    if (s.charAt(start) != '(' && s.charAt(start) != ')') {
      path.append(s.charAt(start)); // always use non-parenthesis characters
      dfsHelper(lCount, rCount, path, start + 1, s, res, correctCount);
      path.deleteCharAt(path.length() - 1);
    } else { // we have two options: use it or not
      path.append(s.charAt(start)); // use this character, either '(' or ')'
      if (s.charAt(start) == '(') {
        dfsHelper(lCount + 1, rCount, path, start + 1, s, res, correctCount);
      } else {
        dfsHelper(lCount, rCount + 1, path, start + 1, s, res, correctCount);
      }
      path.deleteCharAt(path.length() - 1);
      // do not use this character
      dfsHelper(lCount, rCount, path, start + 1, s, res, correctCount);
    }
  }

  private int getCorrectCount(String s) {
    int lCount = 0, correctCount = 0;
    for (int i = 0; i < s.length(); ++i) {
      if (s.charAt(i) == '(') {
        ++lCount;
      } else if (s.charAt(i) == ')') {
        if (lCount > 0) {
          ++correctCount;
          --lCount;
        }
      }
    }
    return correctCount;
  }
}
