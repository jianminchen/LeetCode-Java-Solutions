/**
 * @see <a href="https://leetcode.com/problems/implement-strstr/">Implement strStr()</a>
 */

public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null) return -1;
        if (needle == null || needle.equals("")) return 0;
        if (haystack.length() < needle.length()) return -1;
        for (int i = 0; i <= haystack.length() - needle.length(); i ++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
