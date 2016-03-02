/**
 * @see <a href="https://leetcode.com/problems/plus-one/">Plus One</a>
 */

public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null) throw new NullPointerException();
        int carryIn = 1;
        int newDigits[] = new int[digits.length];
        for(int i = digits.length - 1; i >= 0; --i) {
            int sum = digits[i] + carryIn;
            carryIn = sum/10;
            newDigits[i] = sum % 10;
        }
        if (carryIn == 0) {
            return newDigits;
        } else {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            for (int i = 1; i < res.length; ++i) {
                res[i] = newDigits[i-1];
            }
            return res;
        }
    }
}
