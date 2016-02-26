/**
 * @see <a href="https://leetcode.com/problems/triangle/">Triangle</a>
 */

public class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
    if (triangle == null) {
      throw new NullPointerException();
    }
    if (triangle.size() == 0) {
      return 0;
    }
    int[] minFromBot = new int[triangle.size()];
    for (int i = 0; i < minFromBot.length; ++i) { // initialize
      minFromBot[i] = triangle.get(triangle.size() - 1).get(i);
    }
    for (int row = triangle.size() - 2; row >= 0; --row) {
      for (int col = 0; col <= row; ++col) {
        minFromBot[col] = Math.min(minFromBot[col], minFromBot[col + 1])
            + triangle.get(row).get(col);
      }
    }
    return minFromBot[0];
  }
}
