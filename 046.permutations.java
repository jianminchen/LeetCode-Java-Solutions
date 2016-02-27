/**
 * @see <a href="https://leetcode.com/problems/permutations/">Permutations</a>
 */

public class Solution {
  public List<List<Integer>> permute(int[] nums) {
    if (nums == null) {
      throw new NullPointerException();
    }
    List<List<Integer>> results = new ArrayList<>();
    dfsHelper(0, nums, results);
    return results;
  }

  private void dfsHelper(int start, int[] nums, List<List<Integer>> results) {
    if (start == nums.length) {
      List<Integer> aRes = new ArrayList<>();
      for (int n : nums) {
        aRes.add(n);
      }
      results.add(aRes);
      return;
    }
    dfsHelper(start + 1, nums, results); // use number at start as the first
    for (int i = start + 1; i < nums.length; ++i) {
      swap(start, i, nums); // use number at i as the first
      dfsHelper(start + 1, nums, results);
      swap(start, i, nums); // restore the array
    }
  }

  private void swap(int i, int j, int[] nums) {
    nums[i] = nums[i] ^ nums[j];
    nums[j] = nums[i] ^ nums[j];
    nums[i] = nums[i] ^ nums[j];
  }
}
