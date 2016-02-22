/**
 * @see <a href="https://leetcode.com/problems/gray-code/">Gray Code</a>
 */

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<Integer>();
        if (n < 0) return list;
        list.add(0);
        if (n == 0) return list;
        list.add(1);
        for (int i = 2; i <= n; ++i) {
            int size = list.size(); // record the old size.
            int num = 1 << (i - 1);
            for (int j = size - 1; j >= 0; --j) {
                list.add(num + list.get(j));
            }
        }
        return list;
    }
}
