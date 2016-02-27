/**
 * @see <a href="https://leetcode.com/problems/integer-to-roman/">Integer to Roman</a>
 */

public class Solution {
    public String intToRoman(int num) {
        char[][] chart = {{'I', 'V'}, {'X', 'L'}, {'C', 'D'}, {'M', ' '}};
        
        int which = 0;
        String s = new String();
        while (num != 0) {
            int digit = num % 10;
            StringBuilder sb = new StringBuilder();
            switch (digit) {
                case 1: case 2: case 3:
                    for (int i = 1; i <= digit; ++i) {
                        sb.append(chart[which][0]);
                    }
                    break;
                case 4:
                    sb.append(chart[which][0]);
                    sb.append(chart[which][1]);
                    break;
                case 5: case 6: case 7: case 8:
                    sb.append(chart[which][1]);
                    for (int i = 6; i <= digit; ++i) {
                        sb.append(chart[which][0]);
                    }
                    break;
                case 9:
                    sb.append(chart[which][0]);
                    sb.append(chart[which + 1][0]);
                    break;
                default:
                    break;
            }
            s = new String(sb) + s;
            num = num / 10;
            ++which;
        }
        return s;
    }
}
