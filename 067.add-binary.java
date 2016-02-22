/**
 * @see <a href="https://leetcode.com/problems/add-binary/">Add Binary</a>
 */

public class Solution {
    public String addBinary(String a, String b) {
        if (a == null) return b;
        if (b == null) return a;
        // if s.length() < b.length();
        if (a.length() < b.length()) return addBinary(b, a);
        // now we can assume that a.length() >= b.length()
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carryIn = 0;
        for (; i >= 0; i --, j --) {
            int iA = a.charAt(i) - '0';
            int iB = 0;
            if (j >= 0) { // we are not done with b yet.
                iB = b.charAt(j) - '0';
            }
            int sum = iA + iB + carryIn;
            carryIn = sum / 2;
            int num = sum % 2;
            sb.insert(0, (char) (num + '0'));
        }
        if (carryIn != 0) sb.insert(0, (char) '1');
        return new String(sb);
    }
}
