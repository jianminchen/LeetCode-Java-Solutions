/**
 * @see <a href="https://leetcode.com/problems/word-break-ii/">Word Break II</a>
 */

public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        // dynamic programming
        // let list.get(i) be the list of strings for s.substring(i);
        // i from 0, to s.length() - 1.
        List<String> res = new ArrayList<>();
        
        Set<Character> charSet = new HashSet<>();
        for (String str : wordDict) {
            for (int i = 0; i < str.length(); ++i) {
                charSet.add(str.charAt(i));
            }
        }
        for (int i = 0; i < s.length(); ++i) {
            if (!charSet.contains(s.charAt(i))) return res;
        }
        List<List<List<String>>> table = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            List<List<String>> strings = new ArrayList<>();
            table.add(strings);
        }
        if (wordDict.contains(s.substring(s.length() - 1))) {
            List<List<String>> last = new ArrayList<>();
            List<String> newList = new LinkedList<>();
            newList.add(s.substring(s.length() - 1));
            last.add(newList);
            table.set(s.length() - 1, last);
        }
        for (int i = s.length() - 2; i >= 0; --i) {
            List<List<String>> prev = new ArrayList<>();
            if (wordDict.contains(s.substring(i))) {
                List<String> list = new LinkedList<>();
                list.add(s.substring(i));
                prev.add(list);
            }
            for (int j = i; j < s.length() - 1; ++j) {
                if (wordDict.contains(s.substring(i, j + 1))) {
                    for (List<String> next : table.get(j + 1)) {
                        List<String> newList = new LinkedList<>();
                        newList.add(s.substring(i, j + 1));
                        newList.addAll(next);
                        prev.add(newList);
                    }
                }
            }
            table.set(i, prev);
        }

        for (List<String> intermediate : table.get(0)) {
            StringBuilder sb = new StringBuilder();
            sb.append(intermediate.get(0));
            for (int i = 1; i < intermediate.size(); ++i) {
                sb.append(" ");
                sb.append(intermediate.get(i));
            }
            res.add(new String(sb));
        }
        return res;
    }
}
