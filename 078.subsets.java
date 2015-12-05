/**
 * @see <a href="https://leetcode.com/problems/subsets/">Subsets</a>
 */

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int[] newNums = nums.clone();
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length == 0) {
            List<Integer> list = new ArrayList<>();
            lists.add(list);
        }
        
        // without this initialization, the output will be empty!!!!!!!!!!!!!!!!!!!!!!!!!
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
        
        
        /*
        for (int i = 0; i < nums.length; ++i) {
            List<List<Integer>> newLists = new ArrayList<>();
            // newLists.addAll(lists); // this is wrong !!!!
            for (List<Integer> someList : lists) {
                List<Integer> newList = new ArrayList<>();
                List<Integer> newList2 = new ArrayList<>();
                
                newList.addAll(someList);
                newList2.addAll(someList);
                newList2.add(nums[i]);
                newLists.add(newList);
                newLists.add(newList2);
            }
            lists = newLists;
        }
        */
        
        return lists;
    }
}
