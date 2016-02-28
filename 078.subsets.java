/**
 * @see <a href="https://leetcode.com/problems/subsets/">Subsets</a>
 */

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length == 0) {
            List<Integer> list = new ArrayList<>();
            lists.add(list);
        }
        List<Integer> firstList = new ArrayList<>();
        lists.add(firstList);
        
        for (int i = 0; i < nums.length; ++i) {
            List<List<Integer>> newLists = new ArrayList<>();
            newLists.addAll(lists);
            for (List<Integer> someList : lists) {
                List<Integer> newList = new ArrayList<>();
                newList.addAll(someList);
                newList.add(nums[i]);
                newLists.add(newList);
            }
            lists = newLists;
        }
        return lists;
    }
}
