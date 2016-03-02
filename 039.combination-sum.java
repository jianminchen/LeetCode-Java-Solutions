/**
 * @see <a href="https://leetcode.com/problems/combination-sum/">Combination Sum</a>
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null) throw new NullPointerException();
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        if (candidates.length == 0) {
            return lists;
        }
        Arrays.sort(candidates);
        lists = combinationSum(candidates, target, 0, candidates.length - 1);
        return lists;
    }
    
    private List<List<Integer>> combinationSum(int[] newCands, int target, int low, int high) {
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        if (low == high) {
            if (target % newCands[low] == 0) {
                int count = target / newCands[low];
                List<Integer> alist = new LinkedList<Integer>();
                for (int i = 0; i < count; ++i) {
                    alist.add(newCands[low]);
                }
                lists.add(alist);
            }
            return lists;
        }

        int numOfSmall = target / newCands[low];
        for (int i = 0; i < numOfSmall; ++i) {
            List<List<Integer>> subRes = combinationSum(newCands, target - newCands[low] * i, low + 1, high);
            if (!subRes.isEmpty()) {
                for (List<Integer> aList : subRes) {
                    List<Integer> newList = new LinkedList<Integer>();
                    for (int j = 0; j < i; ++j) newList.add(newCands[low]);
                    newList.addAll(aList);
                    lists.add(newList);
                }
            }
        }
        
        if (target % newCands[low] == 0) { // can use only the newCands[low] value.
            List<Integer> newList = new LinkedList<Integer>();
            for (int j = 0; j < numOfSmall; ++j) newList.add(newCands[low]);
            lists.add(newList);
        }
        return lists;
    }
}
