/**
 * @see <a href="https://leetcode.com/problems/add-digits/">Add Digits</a>
 */

public class Solution {
    public int addDigits(int num) {
        // iterative solution:
        /*
        while (true) {
            int res = 0; // every time calcuate from new values.
            while (num > 0) {
                res += num % 10;
                num = num / 10;
            }
            if (res < 10)
                return res;
            num = res;
        }
        */
        
        // recursive solution:
        /*
        if (num < 10)  return num;
        int res = num % 10 + addDigits(num / 10);
        // if (res < 10) return res;
        // else return addDigits(res);
        return addDigits(res);
        */
        
        // how to make it O(1)?
        // we only have 0 ~ 9, 10 possible solutions.
        // 0 is returned when and only when num == 0
        // after that, 1 ~ 9 are return one by one.
        if (num == 0) return 0;
        if (num % 9 == 0)  return 9;
        else return num % 9;
    }
}
