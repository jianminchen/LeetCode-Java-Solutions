/**
 * @see <a href="https://leetcode.com/problems/integer-to-english-words/">Integer to English Words</a>
 */

public class Solution {
    private String[] chart1 = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", 
            "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
            "Seventeen", "Eighteen", "Nineteen" };
    private String[] chart2 = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private String[] chart3 = {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        if (num < 1000) { // num will not be zero
            if (num % 100 == 0) {
                return chart1[num/100] + " " + "Hundred";
            } else {
                int hundred = num / 100;
                String s = new String();
                if (hundred != 0) {
                    s = chart1[hundred] + " " + "Hundred" + " ";
                }
                int smallNum = num % 100; 
                if (smallNum != 0) {
                    if (smallNum < 20) {
                        s += chart1[smallNum];
                    } else if (smallNum % 10 == 0) {
                        s += chart2[smallNum / 10 - 2];
                    } else {
                        s += chart2[smallNum / 10 - 2] + " ";
                        s += chart1[smallNum % 10];
                    }
                }
                return s;
            }
        }
        
        String res = new String();
        int c3i = 0;
        while (num > 0) {
            int smallNum = num % 1000;
            if (smallNum != 0) {
                String news = " " + numberToWords(smallNum);
                // if c3i == 0. will not append thousand, million, billion, etc. thus, no space needed.
                if (c3i > 0) news = news + " " + chart3[c3i];
                res = news + res;
            }
            ++c3i;
            num = num / 1000;
        }
        return res.substring(1);
    }
}
