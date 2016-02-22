/**
 * @see <a href="https://leetcode.com/problems/strobogrammatic-number/">Strobogrammatic Number</a>
 */

public class Solution {
    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) return true;
        if (num.length() % 2 == 1 && num.charAt(num.length()/2) != '1' 
            && num.charAt(num.length()/2) != '8' && num.charAt(num.length()/2) != '0') return false;
        for (int i = 0; i < num.length()/2; i ++) {
            char c1 = num.charAt(i);
            char c2 = num.charAt(num.length() - 1 - i);
            if (c1 != '6' && c1 != '9' && c1 != '1' && c1 != '8' && c1 != '0') {
                return false;
            }
            if (c2 != '6' && c2 != '9' && c2 != '1' && c2 != '8' && c2!= '0') {
                return false;
            }
            if (c1 == '6') {
                if (c2 != '9') return false;
            }
            if (c1 == '9') {
                if (c2 != '6') return false;
            }
            if (c1 == '1') {
                if (c2 != '1') return false;
            }
            if (c1 == '8') {
                if (c2 != '8') return false;
            }
            if (c1 == '0') {
                if (c2 != '0') return false;
            }
        }
        return true;
    }
}
