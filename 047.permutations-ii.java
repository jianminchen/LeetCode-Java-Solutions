/**
 * @see <a href="https://leetcode.com/problems/permutations-ii/">Permutations II</a>
 */

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> first = new ArrayList<Integer>();
        int[] newNums = nums.clone();
        Arrays.sort(newNums);
        for (int i = 0; i < newNums.length; ++i) {
            first.add(newNums[i]);
        }
        lists.add(first);
        
        while (true) {
            List<Integer> next = new ArrayList<Integer>();
            // find the index where we should go to the next number/list.
            int i = newNums.length - 1;
            while (i >= 1 && newNums[i - 1] >= newNums[i]) --i;
            if (i == 0) break; // we've got all numbers.
            
            Arrays.sort(newNums, i, newNums.length);
            int j = i;
            while (j < newNums.length && newNums[i - 1] >= newNums[j]) ++j;
            // swap i and j
            swap(newNums, i - 1, j);

            for (int k = 0; k < newNums.length; ++k) {
                next.add(newNums[k]);
            }
            lists.add(next);
        }
        
        return lists;
    }
    
    public void swap(int[] newNums, int i, int j) {
        newNums[i] = newNums[j] ^ newNums[i];
        newNums[j] = newNums[i] ^ newNums[j];
        newNums[i] = newNums[i] ^ newNums[j];
    }
}
