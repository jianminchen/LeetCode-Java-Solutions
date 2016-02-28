/**
 * @see <a href="https://leetcode.com/problems/pascals-triangle-ii/">Pascal's Triangle II</a>
 */

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) throw new IllegalArgumentException();
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            List<Integer> nextList = new ArrayList<Integer>();
            nextList.add(1);
            for (int j = 1; j < i; ++j) {
                nextList.add(res.get(j - 1) + res.get(j));
            }
            nextList.add(1);
            res = nextList;
        }
        return res;
    }
}
