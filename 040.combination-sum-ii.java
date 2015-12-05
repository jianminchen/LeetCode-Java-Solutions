/**
 * @see <a href="https://leetcode.com/problems/combination-sum-ii/">Combination Sum II</a>
 */

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int[] newCands = candidates.clone();
        Arrays.sort(newCands);
        // actually do not need the upper bound.
        Set<List<Integer>> set = combinationSum(newCands, target, 0 /* , newCands.length - 1 */);
        
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> list : set) {
            res.add(list);
        }
        return res;
    }
    public Set<List<Integer>> combinationSum(int[] candidates, int target, int start) {
        Set<List<Integer>> set = new HashSet<>();
        /* base case are not fully considered. empty output for input: 10,1,2,7,6,1,5
        // wrong
        if (start == candidates.length - 1) {
            if (candidates[start] == target) {
                List<Integer> list = new ArrayList<>();
                list.add(candidates[start]);
                set.add(list);
            }
            return set;
        }
        if (candidates[start] > target) return set; // the smallest number is greater than target, no result will be found.
        */
        // the smallest number is greater than target, no result will be found. 
        if (start >= candidates.length || candidates[start] > target) return set; 
        if (candidates[start] == target) {
            List<Integer> list = new ArrayList<>();
            list.add(candidates[start]);
            set.add(list);
            return set;
        }
        // use candidates[start].
        Set<List<Integer>> partial = combinationSum(candidates, target - candidates[start], start + 1);
        for (List<Integer> list : partial) {
            List<Integer> newList = new ArrayList<>();
            newList.add(candidates[start]);
            newList.addAll(list);
            set.add(newList);
        }
        // do not use candidates[start], previously did not consider this case, what the hell???????????
        Set<List<Integer>> partial2 = combinationSum(candidates, target, start + 1);
        for (List<Integer> list : partial2) {
            List<Integer> newList = new ArrayList<>();
            newList.addAll(list);
            set.add(newList);
        }
        return set;
    }
}
