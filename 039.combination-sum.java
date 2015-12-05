/**
 * @see <a href="https://leetcode.com/problems/combination-sum/">Combination Sum</a>
 */

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // do the candidates have duplicates???
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        if (candidates.length == 0) {
            return lists;
        }
        Set<Integer> cands = new HashSet<Integer>();
        for (int i : candidates) {
            cands.add(i);
        }
        int[] newCands = new int[cands.size()];
        int index = 0;
        for (int num : cands) {
            newCands[index] = num;
            ++index;
        }
        Arrays.sort(newCands);
        // newCands : no duplicates, sorted, size >= 1;
        // method 1: backtracking
        // we use a stack to store the indices of the number in the newCands.
        // get the first possible solution
        // method 2: recursion.
        lists = combinationSum(newCands, target, 0, newCands.length - 1);
        return lists;
    }
    
    public List<List<Integer>> combinationSum(int[] newCands, int target, int low, int high) {
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        // previously written as low = high, wrong !!!!!!
        // = is not == !!!!!!!!!!!!!!!!!!
        if (low == high) {
            // if (target == 0) return lists; // must be positive values?
            if (target % newCands[low] != 0) return lists;
            else {
                int count = target / newCands[low];
                List<Integer> alist = new LinkedList<Integer>();
                for (int i = 0; i < count; ++i) {
                    alist.add(newCands[low]);
                }
                // previously forgot the following two lines!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                lists.add(alist);
                return lists;
            }
        }

        int numOfSmall = target / newCands[low];
        // we use 0 newCands[low], 1 newCands[low], ..., numOfSmall;
        for (int i = 0; i < numOfSmall; ++i) {
            List<List<Integer>> subRes = combinationSum(newCands, target - newCands[low] * i, low + 1, high);
            if (!subRes.isEmpty()) {
                for (List<Integer> aList : subRes) {
                    List<Integer> newList = new LinkedList<Integer>();
                    // the case of i == 0 will be automatically skipped.
                    for (int j = 0; j < i; ++j) newList.add(newCands[low]);
                    newList.addAll(aList);
                    lists.add(newList);
                }
            }
        }
        
        if (target % newCands[low] == 0) { // can use only the newCands[low] value.
            List<Integer> newList = new LinkedList<Integer>();
            // the case of i == 0 will be automatically skipped.
            for (int j = 0; j < numOfSmall; ++j) newList.add(newCands[low]);
            lists.add(newList);            
        }
        return lists;
    }
}
