/**
 * @see <a href="https://leetcode.com/problems/longest-increasing-subsequence/">Longest Increasing Subsequence</a>
 */

public class Solution {
    public int lengthOfLIS(int[] nums) {
        /*
        if (nums == null || nums.length == 0) return 0;
        int max = 1;
        for (int i = 0; i < nums.length - 1; ++i) {
            int maxLen = 1;
            int prev = nums[i];
            for (int j = i + 1; j < nums.length; ++j) {
            // the logic is wrong !!!!
            // maybe the next is very large, but after that,
            // we have numbers larger than the first one,
            // and smaller than the new prev.
                if (nums[j] > prev) { 
                    prev = nums[j];
                    ++maxLen;
                }
            }
            max = Math.max(max, maxLen);
        }
        return max;
        */
        
        /* still seems not correct.
        class MyNumber implements Comparable<MyNumber> {
            int val;
            int index;
            MyNumber(int v, int i) { val = v; index = i};
            int compareTo(MyNumber num) {
                return val - num.val;
            }
        }
        
        if (nums == null || nums.length == 0) return 0;
        List<MyNumber> list = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            MyNumber newNum = new MyNumber(nums[i], i);
            list.add(newNum);
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); ++i) {
            
        }
        */
        // dynamic programming.
        if (nums == null || nums.length == 0) return 0;
        int maxLen[] = new int[nums.length];
        for (int i = 0; i < maxLen.length; ++i) {
            maxLen[i] = 1;
        }
        for (int i = maxLen.length - 2; i >= 0; --i) {
            for (int j = i + 1; j < maxLen.length; ++j) {
                if (nums[i] < nums[j]) {
                    maxLen[i] = Math.max(maxLen[i], 1 + maxLen[j]);
                }
            }
        }
        // maxLen[i] will be the max len of a subsequence that start at i.
        // the result should not be maxLen[0]
        // return maxLen[0];
        int max = maxLen[0];
        for (int i = 1; i < maxLen.length; ++i) {
            if (max < maxLen[i]) max = maxLen[i];
        }
        return max;
    }
}
