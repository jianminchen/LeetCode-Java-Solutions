/**
 * @see <a href="https://leetcode.com/problems/spiral-matrix/">Spiral Matrix</a>
 */

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) throw new NullPointerException();
        List<Integer> list = new ArrayList<Integer>();
        if (matrix.length == 0 || matrix[0].length == 0) return list; 

        boolean goRight = true, goDown = false, goLeft = false, goUp = false;
        int  rightBound = matrix[0].length - 1, lowerBound = matrix.length - 1, leftBound = 0, upperBound = 1;
        int count = 0;
        int i = 0, j = 0;
        if (matrix[0].length  == 1) {
            goRight = false;
            goDown = true;
        }
        while (count / matrix[0].length < matrix.length) {
            list.add(matrix[i][j]);
            if (goRight) {
                ++j;
                if (j == rightBound) {
                    goRight = false;
                    goDown = true;
                    --rightBound;
                }
            } else if (goDown) {
                ++i;
                if (i == lowerBound) {
                    goDown = false;
                    goLeft = true;
                    --lowerBound;
                }
            } else if (goLeft) {
                --j;
                if (j == leftBound) {
                    goLeft = false;
                    goUp = true;
                    ++leftBound; // don't forget semicolon.
                }
            } else { // goUp
                --i;
                if (i == upperBound) {
                    goUp = false;
                    goRight = true;
                    ++upperBound;
                }
            }
            ++count;
        }
        return list;
    }
}
