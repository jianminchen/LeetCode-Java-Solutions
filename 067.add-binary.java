/**
 * @see <a href="https://leetcode.com/problems/add-binary/">Add Binary</a>
 */

public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || b == null) throw new NullPointerException();
        if (a.length() < b.length()) return addBinary(b, a);
        // now we can assume that a.length() >= b.length()
        Stack<Character> stk = new Stack<>();
        int i = a.length() - 1, j = b.length() - 1;
        int carryIn = 0;
        for (; i >= 0; --i, --j) {
            int iA = a.charAt(i) - '0';
            int iB = 0;
            if (j >= 0) { // we are not done with b yet.
                iB = b.charAt(j) - '0';
            }
            int sum = iA + iB + carryIn;
            carryIn = sum / 2;
            int num = sum % 2;
            stk.push((char) (num + '0'));
        }
        if (carryIn != 0) stk.push((char) '1');
        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) sb.append(stk.pop());
        return new String(sb);
    }
}
