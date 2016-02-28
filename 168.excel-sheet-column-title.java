/**
 * @see <a href="https://leetcode.com/problems/excel-sheet-column-title/">Excel Sheet Column Title</a>
 */

public class Solution {
    public String convertToTitle(int n) {
        String s = new String();
        while (n != 0) {
            int remain = n % 26;
            if (remain == 0) {
                s = 'Z' + s;
                n = (n - 26)/26;
            } else { // some remainder
                s = (new Character((char)('A' + remain - 1))).toString() + s;
                n = (n - remain)/26;
            }
        }
        return s;
    }
}
