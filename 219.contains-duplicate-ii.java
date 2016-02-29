/**
 * @see <a href="https://leetcode.com/problems/contains-duplicate-ii/">Contains Duplicate II</a>
 */

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // a hashMap stores the last index of the number.
        Map<Integer, Integer> hm = new HashMap<>();
        if (nums == null || nums.length == 0) return false;
        if (k <= 0) return false;
        for (int i = 0; i < nums.length; ++i) {
            if (hm.containsKey(nums[i])) {
                if (i - hm.get(nums[i]) <= k) return true;
            }
            hm.put(nums[i], i); // add new or update
        }
        return false;
    }
}
