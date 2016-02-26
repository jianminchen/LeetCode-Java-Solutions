/**
 * @see <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/">Letter Combinations of a Phone Number</a>
 */

public class Solution {
  public List<String> letterCombinations(String digits) {
    if (digits == null) {
      throw new NullPointerException();
    }
    List<String> res = new ArrayList<String>();
    if (digits.length() == 0) {
      return res;
    }
    String[] chart = {" ", "", "abc", "def", "ghi", "jkl", "mno", 
        "pqrs", "tuv", "wxyz"};
    res.add("");
    for (int i = 0; i < digits.length(); ++i) {
      List<String> nextList = new ArrayList<String>();
      for (String s : res) {
        for (int j = 0; j < chart[digits.charAt(i) - '0'].length(); ++j) {
          String newS = s + chart[digits.charAt(i) - '0'].charAt(j);
          nextList.add(newS);
        }
      }
      res = nextList;
    }
    return res;
  }
}
