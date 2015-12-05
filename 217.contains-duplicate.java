/**
 * @see <a href="https://leetcode.com/problems/contains-duplicate/">Contains Duplicate</a>
 */

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return false;
        Set<Integer> hs = new HashSet<Integer>();
        for (int i : nums) {
            if (hs.contains(i)) return true;
            else hs.add(i);
        }
        return false;
    }
}
