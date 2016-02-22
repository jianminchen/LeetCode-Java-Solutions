/**
 * @see <a href="https://leetcode.com/problems/add-digits/">Add Digits</a>
 */

public class Solution {
    public int addDigits(int num) {
        // how to make it O(1)?
        // we only have 0 ~ 9, 10 possible solutions.
        // 0 is returned when and only when num == 0
        // after that, 1 ~ 9 are return one by one.
        if (num == 0) return 0;
        if (num % 9 == 0)  return 9;
        else return num % 9;
    }
}
