/**
 * @see <a href="https://leetcode.com/problems/pascals-triangle/">Pascal's Triangle</a>
 */

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (0 >= numRows) return res;
        List<Integer> first = new ArrayList<>();
        first.add(1);
        res.add(first);
        for (int i = 1; i < numRows; ++i) {
            List<Integer> nextList = new ArrayList<Integer>();
            nextList.add(1);
            for (int j = 1; j < i; ++j) {
                nextList.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }
            nextList.add(1);
            res.add(nextList);
        }
        return res;
    }
}
