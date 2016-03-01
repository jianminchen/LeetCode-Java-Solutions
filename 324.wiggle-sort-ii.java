/**
 * https://leetcode.com/problems/wiggle-sort-ii/ 
 */

public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null) throw new NullPointerException();
        if (nums.length == 0 || nums.length == 1) return;
        int len = nums.length; // actually can name it as n.
        int medianRank = len % 2 == 0 ? len / 2 : len / 2 + 1;
        int median = quickSelect(nums, 0, len - 1, medianRank);
        
        // System.out.println(median);
        List<Integer> lSmaller = new ArrayList<>();
        List<Integer> lGreater = new ArrayList<>();
        for (int num : nums) {
            if (num < median) {
                lSmaller.add(num);
            }
            else if (num > median) {
                lGreater.add(num);
            }
        } // we skip num that is equal to median.
        int smallerSize = medianRank;
        int greaterSize = len - medianRank;
        while (lSmaller.size() < smallerSize) {
            lSmaller.add(median);
        }
        while (lGreater.size() < greaterSize) {
            lGreater.add(median);
        }
        
        int[] space = new int[len];
        int j = lSmaller.size() - 1;
        for (int i = 0; i < len; i += 2) {
            space[i] = lSmaller.get(j);
            --j;
        }
        j = 0;
        for (int i = 1; i < len; i += 2) {
            space[i] = lGreater.get(j);
            ++j;
        }
        // we need to copy space into nums!!!
        for (int i = 0; i < len; ++i) {
            nums[i] = space[i];
        }
    }
    
    private int quickSelect(int[] nums, int si, int ei, int k) { 
        if (ei == si) return nums[ei];
        int pIndex = si + ((ei - si)>>1); // can use randomization to avoid worst case.
        int pValue = nums[pIndex];
        swap(nums, pIndex, ei);
        int storeIndex = si;
        for (int i = si; i <= ei - 1; ++i) {
            if (nums[i] < pValue) {
                swap(nums, i, storeIndex);
                ++storeIndex;
            }
        }
        swap(nums, storeIndex, ei);
        if (storeIndex - si + 1 == k) return nums[storeIndex];
        else if (storeIndex - si + 1 < k) {
            return quickSelect(nums, storeIndex + 1, ei, k - (storeIndex + 1 - si));
        }
        else return quickSelect(nums, si, storeIndex - 1, k);
    }
    
    private void swap(int[] nums, int i, int j) {
        if (i == j) return;
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
