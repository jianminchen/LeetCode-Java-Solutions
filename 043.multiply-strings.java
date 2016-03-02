/**
 * @see <a href="https://leetcode.com/problems/multiply-strings/">Multiply Strings</a>
 */

public class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) throw new NullPointerException();
        if (num1.length() == 0 || num2.length() == 0 ||
            num1.equals("0") || num2.equals("0")) return "0";
        List<String> lists = new ArrayList<>();
        int zeroCount = 0;
        for (int i = num2.length() - 1; i >= 0; --i) {
            if (num2.charAt(i) != '0') {
                StringBuilder sb = multiply(num1, num2.charAt(i));
                for (int j = 0; j < zeroCount; ++j) {
                    sb.append(0);
                }
                lists.add(new String(sb));
            }
            ++zeroCount;
        }
        
        String res = lists.get(0);
        for (int i = 1; i < lists.size(); ++i) {
            res = addTwoStrings(res, lists.get(i));
        }
        return res;
    }
    
    private StringBuilder multiply(String num1, char c) {
        // num1 is not "0".
        StringBuilder sb = new StringBuilder();
        int cDigit = c - '0';
        if (cDigit == 0) {
            sb.append(0); return sb;
        }
        int carryIn = 0;
        for (int i = num1.length() - 1; i >= 0; --i) {
            int product = carryIn + cDigit * (num1.charAt(i) - '0');
            int digit = product % 10;
            carryIn = product / 10;
            sb.insert(0, digit);
        }
        if (carryIn != 0) sb.insert(0, carryIn);
        return sb;
    }
    
    private String addTwoStrings(String s1, String s2) {
        String res = new String();
        int carryIn = 0;
        for (int i = 0; i <= s1.length() - 1 || i <= s2.length() - 1; ++i) {
            int digit1 = 0, digit2 = 0;
            if (i <= s1.length() - 1) digit1 = s1.charAt(s1.length() - 1 - i) - '0';
            if (i <= s2.length() - 1) digit2 = s2.charAt(s2.length() - 1 - i) - '0';
            int sum = digit1 + digit2 + carryIn;
            int digit = sum % 10;
            res = digit + res;
            carryIn = sum / 10;
        }
        if (carryIn != 0) res = carryIn + res;
        return res;
    }
}
