/**
 * @see <a href="https://leetcode.com/problems/4sum/">4Sum</a>
 */

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null) throw new NullPointerException();
        if (nums.length < 4) return new ArrayList<List<Integer>>();
        int[] newNums = nums.clone(); // if we are not allowed to alter the input, we can make a copy of the input.
        Arrays.sort(newNums);
        int n = nums.length;
        
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= n - 4; ++i) {
            if (i > 0 && newNums[i] == newNums[i - 1]) continue;
            for (int j = i + 1; j <= n - 3; ++j) {
                if (j > i + 1 && newNums[j] == newNums[j - 1]) continue;
                
                int low = j + 1;
                int high = n - 1;
                int sum = newNums[i] + newNums[j];
                while (low < high) {
                    if (low > j + 1 && newNums[low] == newNums[low - 1]) {
                        ++low;
                        continue;
                    }
                    if (high < n - 1 && newNums[high] == newNums[high + 1]) {
                        --high;
                        continue;
                    }
                    if (sum + newNums[low] + newNums[high] == target) {
                        List<Integer> aRes = new ArrayList<>();
                        aRes.add(newNums[i]);
                        aRes.add(newNums[j]);
                        aRes.add(newNums[low]);
                        aRes.add(newNums[high]);
                        res.add(aRes);
                        ++low;
                        --high;
                    } else if (sum + newNums[low] + newNums[high] < target) {
                        ++low;
                    } else {
                        --high;
                    }
                }
            }
        }
        return res;
    }
}
