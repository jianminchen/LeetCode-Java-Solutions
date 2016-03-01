/**
 * @see <a href="https://leetcode.com/problems/majority-element-ii/">Majority Element II</a>
 */

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if (nums == null) throw new NullPointerException();
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) return res;
        int first = 0, second = 0, firstCount = 0, secondCount = 0;

        for (int i = 0; i < nums.length; ++i) { // first, find the candidates
            if (firstCount == 0) {
                if (secondCount != 0 && nums[i] == second) {
                    ++secondCount;
                } else {
                    first = nums[i];
                    ++firstCount;                    
                }
            } else if (secondCount == 0) {
                if (first == nums[i]) {
                    ++firstCount;
                } else {
                    second = nums[i];
                    ++secondCount;
                }
            } else {
                if (first == nums[i]) {
                    ++firstCount;
                } else if (second == nums[i]) {
                    ++secondCount;
                } else {
                    --firstCount;
                    --secondCount;
                }
            }
        }
        
        // to verify that they are indeed the majority number
        firstCount = 0;
        secondCount = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (first == nums[i]) ++firstCount;
            if (second == nums[i]) ++secondCount;
        }
        if (firstCount > nums.length / 3) res.add(first);
        if (first != second && secondCount > nums.length / 3) res.add(second);
        return res;
    }
}
