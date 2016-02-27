/**
 * @see <a href="https://leetcode.com/problems/implement-strstr/">Implement strStr()</a>
 */

public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) throw new NullPointerException();
        if (haystack.length() < needle.length()) return -1;
        for (int i = 0; i <= haystack.length() - needle.length(); i ++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
