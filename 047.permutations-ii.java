/**
 * @see <a href="https://leetcode.com/problems/permutations-ii/">Permutations II</a>
 */

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(0, nums, res);
        return res;
    }
    
    private void helper(int start, int[] nums, List<List<Integer>> res) {
        if (start == nums.length) {
            List<Integer> aRes = new ArrayList<>();
            for (int n : nums) aRes.add(n);
            res.add(aRes);
            return;
        }
        Set<Integer> frontSet = new HashSet<>();
        for (int i = start; i < nums.length; ++i) {
            // if we have done so for the same value, we will not consider it again in the future.
            if (!frontSet.contains(nums[i])) {
                frontSet.add(nums[i]);
                swap(start, i, nums);
                helper(start + 1, nums, res);
                swap(start, i, nums); // restore the array.
            }
        }
    }
    
    private void swap(int i, int j, int[] nums) {
        if (i == j) return;
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
