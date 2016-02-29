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
    
    private boolean isAdditiveNumber(String n1, String n2, String num) {
        String addS = addTwoStrings(n1, n2);
        if ((n1.length() > 1 && n1.charAt(0) == '0') || (n2.length() > 1 && n2.charAt(0) == '0')) return false;
        if (num.length() - n1.length() - n2.length() < addS.length()) return false;

        if (!addS.equals(num.substring(n1.length() + n2.length(), n1.length() + n2.length() + addS.length()))) {
            return false;
        } else {
            if (addS.length() + n1.length() + n2.length() == num.length()) {
                return true;
            } else {
                return isAdditiveNumber(n2, addS, num.substring(n1.length()));                
            }
        }
    }
    
    private String addTwoStrings(String s1, String s2) {
        String s = new String();
        int i = s1.length() - 1, j = s2.length() - 1;
        int cIn = 0;
        for (; i >= 0 || j >= 0; --i, --j) {
            int dgt1 = i >= 0 ? s1.charAt(i) - '0' : 0;
            int dgt2 = j >= 0 ? s2.charAt(j) - '0' : 0;
            int sum = cIn + dgt1 + dgt2;
            int dgt = sum % 10;
            cIn = sum / 10;
            s = dgt + s;
        }
        if (cIn != 0) s = cIn + s;
        return s;
    }
}
