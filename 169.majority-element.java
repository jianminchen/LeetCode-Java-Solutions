/**
 * @see <a href="https://leetcode.com/problems/majority-element/">Majority Element</a>
 */

public class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null) throw new NullPointerException();
        if (nums.length == 0) throw new IllegalArgumentException();
        int cand = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (cand == nums[i]) {
                ++count;
            } else { // cand != nums[i]
                --count;
                if (count == 0) {
                    cand = nums[i];
                    count = 1;
                }
            }
        }
        return cand;
    }
}
