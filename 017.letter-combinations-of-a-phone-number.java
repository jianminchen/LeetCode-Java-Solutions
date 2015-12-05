/**
 * @see <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/">Letter Combinations of a Phone Number</a>
 */

public class Solution {
    public List<String> letterCombinations(String digits) {
        
        // what should be returned when there is a 1 in the digits string??
        // test cases show that we should return a list of no strings, instead of a list of empty string!!!!!!!!
        // this is actually easier.
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
            // if we have a '1', return directly, as assumed by the test cases
            // if we have a '0', return directly, as assumed by the test cases
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
        
        /* the following solution has different assumption as the problem,
        // i.e., the following solution assume when a 1 appears, use "", instead of return a list of no strings directly.
        if (digits.length() == 0) return res;
        // consider the first char
        String s = chart[digits.charAt(0) - '0'];
        if (s.equals("")) res.add("");
        else {
            for (int i = 0; i < s.length(); ++i) {
                String cs = new String();
                cs = cs + s.charAt(i);
                res.add(cs);
            }
        }
        for (int i = 1; i < digits.length(); ++i) {
            List<String> nextList = new ArrayList<String>();
            if (digits.charAt(i) == '1') {
                nextList.addAll(res);
            }
            else {
                String toAppend = chart[digits.charAt(i) - '0'];
                for (String aStr : res) {
                    for (int j = 0; j < toAppend.length(); ++j) {
                        String newStr = aStr + toAppend.charAt(j);
                        nextList.add(newStr);
                    }
                }
            }
            res = nextList;
        }
        */
        return res;
    }
}
