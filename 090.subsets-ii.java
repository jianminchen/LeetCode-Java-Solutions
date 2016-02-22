/**
 * @see <a href="https://leetcode.com/problems/subsets-ii/">Subsets II</a>
 */

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            List<Integer> r = new ArrayList<>();
            res.add(r);
            return res;
        }
        Arrays.sort(nums);
        Set<List<Integer>> curSet = new HashSet<>();
        List<Integer> r = new ArrayList<>();
        curSet.add(r);
        for (int i = 0; i < nums.length; ++i) {
            Set<List<Integer>> nextSet = new HashSet<>();
            nextSet.addAll(curSet);
            for (List<Integer> aRes : curSet) {
                List<Integer> newRes = new ArrayList<>();
                newRes.addAll(aRes);
                newRes.add(nums[i]);
                
                nextSet.add(newRes);
            }
            curSet = nextSet;
        }
        for (List<Integer> aRes : curSet) {
            res.add(aRes);
        }
        return res;
    }
}
