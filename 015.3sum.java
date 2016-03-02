/**
 * @see <a href="https://leetcode.com/problems/3sum/">3Sum</a>
 */

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null) throw new NullPointerException();
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 3) return lists;
        for (int i = 0; i < nums.length - 2; ++i) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                if (low != i + 1 && nums[low] == nums[low - 1]) {
                    ++low;
                    continue;
                }
                if (high != nums.length - 1 && nums[high] == nums[high + 1]) {
                    --high;
                    continue;
                }
                if (nums[low] + nums[high] > 0 - nums[i]) {
                    --high;
                } else if (nums[low] + nums[high] == 0 - num}s[i]) {
                    List<Integer> aRes = new ArrayList<Integer>();
                    aRes.add(nums[i]);
                    aRes.add(nums[low]);
                    aRes.add(nums[high]);
                    lists.add(aRes);
                    ++low;
                    --high;
                } else {
                    ++low;
                }
            }
        }
        return lists;
    }
}
