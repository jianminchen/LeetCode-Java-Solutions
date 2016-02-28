/**
 * @see <a href="https://leetcode.com/problems/reverse-words-in-a-string-ii/">Reverse Words in a String II</a>
 */

public class Solution {
    public void reverseWords(char[] s) {
        int i = 0;
        while(i < s.length) {
            int start = i;
            while (i < s.length && s[i] != ' ') ++i;
            reverse(s, start, i - 1);
            ++i;
        }
        reverse(s, 0, s.length - 1);
    }
    public void reverse(char[] s, int from, int to) {
        for (int i = 0; i <= (to - from) >> 1; ++i) {
            char temp = s[from + i];
            s[from + i] = s[to - i];
            s[to - i] = temp;
        }
    }
}
