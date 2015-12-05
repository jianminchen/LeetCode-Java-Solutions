/**
 * @see <a href="https://leetcode.com/problems/gray-code/">Gray Code</a>
 */

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<Integer>();
        // return [0] when n == 0 ??????????? why ?????????
        if (n < 0) return list;
        list.add(0);
        if (n == 0) return list;
        list.add(1);
        // when n == 1, the loop will not be entered, it's fine.
        // if (n == 1) return list;
        for (int i = 2; i <= n; ++i) {
            /* don't need to create a new list.
            List<Integer> newList = new ArrayList<Integer>();
            newList.addAll(list);
            int num = 1 <<(i - 1);
            for (int j = list.size() - 1; j >= 0; --j) {
                newList.add(list.get(j) + num);
            }
            list = newList;
            */
            int size = list.size(); // record the old size.
            int num = 1 << (i - 1);
            // key: the second half will be added backward.
            for (int j = size - 1; j >= 0; --j) {
                list.add(num + list.get(j));
            } // this will duuble the size of the list.
        }
        return list;
    }
}
