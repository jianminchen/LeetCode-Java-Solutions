/**
 * @see <a href="https://leetcode.com/problems/longest-common-prefix/">Longest Common Prefix</a>
 */

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return ""; // why do we need to return "", instead of null ????!!!!!!!!!!!!!!!!
        for (int i = 0; i < strs.length; i ++) {
            if (strs[i] == null) return "";// why do we need to return "", instead of null ????!!!!!!!!!!!!!
        }
        for (int i = 0; ; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (i == strs[j].length()) return strs[0].substring(0, i);
            }
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != strs[j-1].charAt(i))
                    return strs[0].substring(0, i);
            }
        }
    }
}
