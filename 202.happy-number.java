/**
 * @see <a href="https://leetcode.com/problems/happy-number/">Happy Number</a>
 */

public class Solution {
    public boolean isHappy(int n) {
        if (n == 1) return true;
        HashSet<Integer> hs = new HashSet<Integer>();
        hs.add(n);
        while(true) {
            int next = 0;
            while (n != 0) {
                next += (n % 10)* (n % 10);
                n = n / 10;
            }
            if (next == 1) {
                return true;
            } else {
                if (hs.contains(next)) {
                    return false;
                } else {
                    hs.add(next);
                }
            }
            n = next;
        }
    }
}
