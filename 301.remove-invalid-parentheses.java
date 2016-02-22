public class Solution {
        public List<String> removeInvalidParentheses(String s) {
                if (s == null) throw new NullPointerException();
                StringBuilder path = new StringBuilder();
                Set<String> res = new HashSet<>(); // use set to avoid duplicates.    
                int correctCount = getCorrectCount(s);
                dfsHelper(0, 0, path, 0, s, res, correctCount);
                return new ArrayList<String>(res);
        }
        private void dfsHelper(int lCount, int rCount, StringBuilder path, 
                               int start, String s, Set<String> res, int correctCount) {
                if (start == s.length()) { // at the end, we may or may not find a solution.
                        if (lCount == rCount && lCount == correctCount) res.add(new String(path));
                        return; // in either case, we need to terminate.
                }
                // to terminate the dfs as early as possible.
                if (rCount > lCount || lCount > correctCount || rCount > correctCount) return;
        
                if (s.charAt(start) != '(' && s.charAt(start) != ')') { //always use non-parenthese chars.        
                        path.append(s.charAt(start));
                        dfsHelper(lCount, rCount, path, start + 1, s, res, correctCount);
                        path.deleteCharAt(path.length() - 1);
                }
                else if (s.charAt(start) == '(') { // we have two options. use it or not.
                        path.append('('); // use this character:
                        dfsHelper(lCount + 1, rCount, path, start + 1, s, res, correctCount);
                        path.deleteCharAt(path.length() - 1);
                        dfsHelper(lCount, rCount, path, start + 1, s, res, correctCount); // do not use
                }
                else { // s.charAt(start) == ')'
                        path.append(')');
                        dfsHelper(lCount, rCount + 1, path, start + 1, s, res, correctCount);
                        path.deleteCharAt(path.length() - 1);
                        dfsHelper(lCount, rCount, path, start + 1, s, res, correctCount);
                }
        }

        private int getCorrectCount(String s) {
                int lCount = 0, correctCount = 0;
                for (int i = 0; i < s.length(); ++i) {
                        if (s.charAt(i) == '(') ++lCount;
                        else if (s.charAt(i) == ')') {
                                if (lCount > 0) {
                                        ++correctCount;
                                       --lCount;
                                }
                        }
                }
                return correctCount;
        }
}

