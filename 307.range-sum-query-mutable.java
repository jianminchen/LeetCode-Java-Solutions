/**
 * https://leetcode.com/problems/range-sum-query-mutable/
 */

public class NumArray {
    // the binary index tree solution.
    private int[] array;
    private int[] BIT;
    public NumArray(int[] nums) {
        array = new int[nums.length];
        BIT = new int[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            update(i, nums[i]);
            array[i] = nums[i];
        }
    }

    public void update(int i, int val) {
        int updateVal = val - array[i];
        int index = i + 1;
        while (index <= array.length) {
            BIT[index] += updateVal;
            index += index & (-index);
        }
        array[i] = val;
    }
    private int getSum(int i) {
        int index = i + 1;
        int sum = 0;
        while (index > 0) {
            sum += BIT[index];
            index -= index & (-index);
        }
        return sum;
    }
    public int sumRange(int i, int j) {
        int sumi = getSum(i - 1);
        int sumj = getSum(j);
        return sumj - sumi;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
