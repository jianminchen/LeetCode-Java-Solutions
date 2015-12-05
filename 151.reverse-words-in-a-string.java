/**
 * @see <a href="https://leetcode.com/problems/reverse-words-in-a-string/">Reverse Words in a String</a>
 */

public class Solution {
    public String reverseWords(String s) {
        List<String> list = new ArrayList<String>();
        int i = 0;
        while (i < s.length()) {
            int start = i;
            while (i < s.length() && s.charAt(i) != ' ') ++i;
            int end = i;
            // the case of s = "     ";
            if (start != end) list.add(s.substring(start, end));
            while (i < s.length() && s.charAt(i) == ' ') ++i;
        }
        StringBuilder sb = new StringBuilder();
        // consider the case of s = "", or s = "     ";
        if (list.size() != 0) sb.append(list.get(list.size() - 1));
        for (int j = list.size() - 2; j >= 0; --j) {
            sb.append(" ");
            sb.append(list.get(j));
        }
        return new String(sb);
    }
}
