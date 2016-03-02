/**
 * @see <a href="https://leetcode.com/problems/subsets-ii/">Subsets II</a>
 */

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null) throw new NullPointerException();
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            res.add(new ArrayList<>()); // using anonymous object to simplify coding.
            return res;
        }
        Arrays.sort(nums);
        Set<List<Integer>> curSet = new HashSet<>();
        curSet.add(new ArrayList<>());
        for (int i = 0; i < nums.length; ++i) {
            // using helpful constructors to simplify coding.
            Set<List<Integer>> nextSet = new HashSet<>(curSet);
            for (List<Integer> aRes : curSet) {
                List<Integer> newRes = new ArrayList<>(aRes);
                newRes.add(nums[i]);
                nextSet.add(newRes);
            }
            curSet = nextSet;
        }
        return new ArrayList<List<Integer>>(curSet);
    }
}
