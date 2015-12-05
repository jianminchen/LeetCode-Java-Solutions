/**
 * @see <a href="https://leetcode.com/problems/two-sum/">Two Sum</a>
 */

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int res[] = new int[2];
        // key is the number, value is the index.
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        hm.put(nums[0], 0);
        for (int i = 1; i < nums.length; ++i) {
            if (!hm.containsKey(target - nums[i])) {
                hm.put(nums[i], i); // whether target - nums[i] == nums[i] or not.
            }
            else {
                // hm.containsKey()
                res[0] = hm.get(target - nums[i]) + 1;
                res[1] = i + 1;
                break;
            }
        }
        return res;
    }
}
