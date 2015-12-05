/**
 * @see <a href="https://leetcode.com/problems/4sum/">4Sum</a>
 */

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int[] newNums = nums.clone();
        // previously, all following code use nums.
        // if you defined newNums, and don't want to change nums. 
        // then, keep to newNums !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        Arrays.sort(newNums);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Set<List<Integer>> setList = new HashSet<List<Integer>>();
        int sum = 0;
        if (newNums.length < 4) return lists;
        for (int i = 0; i <= newNums.length - 4; ++i) {
            for (int j = i + 1; j <= newNums.length - 3; ++j) {
                int low = j + 1;
                int high = newNums.length - 1;
                sum = newNums[i] + newNums[j]; // every time use new i, j.
                while (low < high) {
                    if (newNums[low] + newNums[high] > target - sum) {
                        --high;
                    }
                    else if (newNums[low] + newNums[high] == target - sum) {
                        List<Integer> aRes = new ArrayList<Integer>();
                        aRes.add(newNums[i]); aRes.add(newNums[j]);
                        aRes.add(newNums[low]); aRes.add(newNums[high]);
                        setList.add(aRes); // avoids duplicates
                        
                        // after that, should do something !!!!!!!!!!!!!!!!!!
                        // otherwise time limit exceeded, because we will not exit the while loop!!!!!!!!!!!!!
                        --high;
                        ++low;
                        
                    }
                    else {
                        // <
                        ++low;
                    }
                }
            }
        }
        for (List<Integer> list : setList) {
            lists.add(list);
        }
        return lists;
    }
}
