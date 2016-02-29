/**
 * @see <a href="https://leetcode.com/problems/permutation-sequence/">Permutation Sequence</a>
 */

public class Solution {
    public String getPermutation(int n, int k) {
        int[] array = new int[n];
        array[0] = 1;
        for (int i = 1; i < n; ++i) {
            array[i] = array[i - 1] * i;
        }
        int[] digits = new int[n]; // the digtis[i]'s digit that has not been used will be used
        for (int i = 0; i < n; ++i) {
            digits[i] = (k - 1) / array[n - 1 - i] + 1;
            k = k - (digits[i] - 1) * array[n - 1 - i];
        }
        int[] realDigits = new int[n];
        boolean[] usedDigits = new boolean[n];
        for (int i = 0; i < n; ++i) {
            int dg = 1;
            for (int j = 1; j < digits[i]; ++j) {
                while (usedDigits[dg - 1] == true) ++dg;
                ++dg;
            }
            while (usedDigits[dg - 1] == true) ++dg; // if digit 1 is already, also need to increase;
            realDigits[i] = dg;
            usedDigits[dg - 1] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            sb.append(realDigits[i]);
        }
        return new String(sb);
    }
}
