/**
 * @see <a href="https://leetcode.com/problems/excel-sheet-column-number/">Excel Sheet Column Number</a>
 */

public class Solution {
    public int titleToNumber(String s) {
        if (s == null) throw new NullPointerException();
        if (s.length() == 0) return 0;
        int multiplier = 1, res = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            int num = s.charAt(i)  - 'A' + 1;
            res += num * multiplier;
            multiplier = multiplier * 26;
        }
        return res;
    }
}
