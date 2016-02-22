/**
 * @see <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/">Letter Combinations of a Phone Number</a>
 */

public class Solution {
    public List<String> letterCombinations(String digits) {
        
        String[] chart = new String[10];
        chart[0] = " ";
        chart[1] = "";
        chart[2] = "abc";
        chart[3] = "def";
        chart[4] = "ghi";
        chart[5] = "jkl";
        chart[6] = "mno";
        chart[7] = "pqrs";
        chart[8] = "tuv";
        chart[9] = "wxyz";
        List<String> res = new ArrayList<String>();
        if (digits.length() == 0) return res;
        for (int i = 0; i < digits.length(); ++i) {
            if (digits.charAt(i) == '1' || digits.charAt(i) == '0') return res; 
        }
        res.add("");
        for (int i = 0; i < digits.length(); ++i) {
            List<String> nextList = new ArrayList<String>();
            String toAppend = chart[digits.charAt(i) - '0'];
            for (String aStr : res) {
                for (int j = 0; j < toAppend.length(); ++j) {
                    String newStr = aStr + toAppend.charAt(j);
                    nextList.add(newStr);
                }
            }
            res = nextList;
        }

        return res;
    }
}
