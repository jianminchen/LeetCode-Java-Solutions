/**
 * @see <a href="https://leetcode.com/problems/length-of-last-word/">Length of Last Word</a>
 */

public class Solution {
    public int lengthOfLastWord(String s) {
        // s.length() == 0, can be included into general cases.
        if (s == null ) throw new NullPointerException();
        int iLast = s.length() - 1;
        while (iLast >= 0 && s.charAt(iLast) == ' ') --iLast;
        if (iLast < 0) return 0;
        int iFirst = iLast;
        while (iFirst >= 0 && s.charAt(iFirst) != ' ') --iFirst;
        return iLast - iFirst;
    }
}
