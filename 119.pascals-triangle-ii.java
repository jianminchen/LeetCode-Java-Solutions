/**
 * @see <a href="https://leetcode.com/problems/pascals-triangle-ii/">Pascal's Triangle II</a>
 */

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        // rowIndex starts from 0.
        List<Integer> li = new ArrayList<Integer>();
        if (rowIndex < 0) return li;
        if (0 == rowIndex) {
            li.add(1);
            return li;
        }
        if (1 == rowIndex) {
            li.add(1);
            li.add(1);
            return li;
        }
        List<Integer> newList = new ArrayList<Integer>();
        newList.add(1); newList.add(1);
        for (int k = 2; k <= rowIndex; k ++) {
            int prev = 1;
            for (int j = 1; j < k; j ++) {
                // use the prev value to calculate
                int newValue = prev + newList.get(j);
                // update the prev before newList.get(j) is overwritten.
                prev = newList.get(j);
                // update the newList.get(j), when prev has stored its prev value.
                newList.set(j, newValue);
            }
            newList.add(1);
        }
        return newList;
    }
}
