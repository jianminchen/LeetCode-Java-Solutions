/**
 * @see <a href="https://leetcode.com/problems/pascals-triangle/">Pascal's Triangle</a>
 */

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if (0 >= numRows) return res;
        if ( 2 >= numRows) {
            List<Integer> aList = new ArrayList<Integer>();
            aList.add(1);
            res.add(aList);
            if (2 == numRows) {
                List<Integer> sList = new ArrayList<Integer>();
                sList.add(1); sList.add(1);
                res.add(sList);
            }
            return res;
        }
        List<List<Integer>> generalRes = generate(2);
        for (int i = 2; i < numRows; i ++) {
            List<Integer> nextList = new ArrayList<Integer>();
            nextList.add(1);
            for (int j = 1; j < i; j ++) {
                nextList.add(generalRes.get(i - 1).get(j - 1) + generalRes.get(i - 1).get(j));
            }
            nextList.add(1);
            generalRes.add(nextList);
        }
        return generalRes;
        
    }
}
