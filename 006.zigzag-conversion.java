/**
 * @see <a href="https://leetcode.com/problems/zigzag-conversion/">ZigZag Conversion</a>
 */

public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return new String(s);
        // the case of numRows == 2 is included in the general code.
        // the first row
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i = i + 2 * numRows - 2) {
            sb.append(s.charAt(i));
        }
        // the second row to the numRows - 2 th row.
        for (int j = 1; j <= numRows - 2; ++j) {
            for (int i = j; i < s.length(); i = i + 2 * numRows - 2) {
                sb.append(s.charAt(i));
                if (i + 2 * (numRows - j - 1) < s.length()) {
                    sb.append(s.charAt(i + 2 * (numRows - j - 1)));
                }
            }
        }
        // the last row
        for (int i = numRows - 1; i < s.length(); i = i + 2 * numRows - 2) {
            sb.append(s.charAt(i));
        }
        return new String(sb);
    }
}
