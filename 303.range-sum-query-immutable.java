/**
 * @see <a href="https://leetcode.com/problems/range-sum-query-immutable/">Range Sum Query - Immutable</a>
 */

public class NumArray {
    // the key to the problem: it is not about mutual exclusion.
    // how to store some of the result, such that we can do efficient calacuation for i, j.
    int[] sumi;
    public NumArray(int[] nums) {
        // newNums = nums.clone();
        sumi = new int[nums.length + 1];
        sumi[0] = 0;
        for (int i = 1; i < nums.length + 1; ++i) {
            sumi[i] = sumi[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sumi[j + 1] - sumi[i];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
