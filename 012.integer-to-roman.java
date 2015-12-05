/**
 * @see <a href="https://leetcode.com/problems/integer-to-roman/">Integer to Roman</a>
 */

public class Solution {
    public String intToRoman(int num) {
        char[][] chart= new char[4][2];
        chart[0][0] = 'I';
        chart[0][1] = 'V';
        chart[1][0] = 'X';
        chart[1][1] = 'L';
        chart[2][0] = 'C';
        chart[2][1] = 'D';
        chart[3][0] = 'M';
        
        int whichDigit = 0;
        String s = new String();
        while (num != 0) {
            int digit = num % 10;
            // only consider the case when digit != 0. if 0, go to the next digit directly
            if (digit != 0) {
                StringBuilder sb = new StringBuilder();
                if (digit <= 3) {
                    for (int i = 1; i <= digit; ++i) {
                        sb.append(chart[whichDigit][0]);
                    }
                } // for the thousand bit, digit cannot be greater than 3.
                else if (digit == 4) {
                    sb.append(chart[whichDigit][0]);
                    sb.append(chart[whichDigit][1]);
                }
                else if (digit == 5) {
                    sb.append(chart[whichDigit][1]);
                }
                else if (digit <= 8) { // digit 6, 7, 8
                    sb.append(chart[whichDigit][1]);
                    // previously written as i <= 8, wrong !!!!!!!!!!!!!!!!
                    for (int i = 6; i <= digit; ++i) {
                        sb.append(chart[whichDigit][0]);
                    }
                }
                else { // digit 9.
                    sb.append(chart[whichDigit][0]);
                    sb.append(chart[whichDigit+1][0]);
                }
                s = (new String(sb)) + s;
            }
            num = num / 10;
            whichDigit ++;
        }
        return s;
    }
}
