/**
 * @see <a href="https://leetcode.com/problems/additive-number/">Additive Number</a>
 */

public class Solution {
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) return false;
        for (int i = 1; i < num.length() - 1; ++i) {
            if (num.charAt(0) == '0' && i >= 2) return false;
            for (int j = i; j < num.length(); ++j) {
                if (num.length() - j - 1 < Math.max(i, j + 1 - i)) break;
                if (j - i >= 1 && num.charAt(i) == '0') break;
                if (isAdditiveNumber(num.substring(0, i), num.substring(i, j + 1), num)) return true;
            }
        }
        return false;
    }
    public boolean isAdditiveNumber(String n1, String n2, String num) {
        String addS = addTwoStrings(n1, n2);
        System.out.println(addS);
        if ((n1.length() > 1 && n1.charAt(0) == '0') || (n2.length() > 1 && n2.charAt(0) == '0')) return false;
        // it is num here, not nums!!!
        if (num.length() - n1.length() - n2.length() < addS.length()) return false;

        if (!addS.equals(num.substring(n1.length() + n2.length(), n1.length() + n2.length() + addS.length()))) return false;
        else {
            if (addS.length() + n1.length() + n2.length() == num.length()) return true;
            else {
                return isAdditiveNumber(n2, addS, num.substring(n1.length()));                
            }
        }
    }
    public String addTwoStrings(String s1, String s2) {
        // the result is backward. when to use string, and when to use stringbuilder?
        // StringBuilder sb = new StringBuilder();
        String s = new String();
        int i = s1.length() - 1, j = s2.length() - 1;
        int cIn = 0;
        while ( i >= 0 || j >= 0) {
            // why not use some simple variables ????????????????
            // previously used digit1, digit2
            // int digit1 = 0;
            // int digit2 = 0;
            int dgt1 = 0;
            int dgt2 = 0;
            // wrong answer reported when used s1.charAt(j) - '0'.
            // can you just be careful???
            if (i >= 0) dgt1 = s1.charAt(i) - '0';
            if (j >= 0) dgt2 = s2.charAt(j) - '0';
            int sum = cIn + dgt1 + dgt2;
            int dgt = sum % 10;
            cIn = sum / 10;
            // StringBuilder does not support plus with integers????!!!!!!!!
            s = dgt + s;
            // don't forget update i and j.
            --i;
            --j;
        }
        if (cIn != 0) s = cIn + s;
        return s;
    }
}
