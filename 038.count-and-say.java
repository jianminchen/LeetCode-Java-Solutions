/**
 * @see <a href="https://leetcode.com/problems/count-and-say/">Count and Say</a>
 */

public class Solution {
    public String countAndSay(int n) {
        if (n <= 0) return "";
        String cur = "1";
        for (int t = 2; t <= n; ++t) {
            StringBuilder sbNext = new StringBuilder();
            int i = 0;
            while (i < cur.length()) {
                int count = 1;
                int j = i + 1;
                for (; j < cur.length() && cur.charAt(j) == cur.charAt(j - 1); ++j) {
                    ++count;
                }
                sbNext.append(count);
                sbNext.append(cur.charAt(i));
                i = j;
            }
            cur = new String(sbNext);
        }
        return cur;
    }
}
