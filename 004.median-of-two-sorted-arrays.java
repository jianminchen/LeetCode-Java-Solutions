/**
 * @see <a href="https://leetcode.com/problems/median-of-two-sorted-arrays/">Median of Two Sorted Arrays</a>
 */

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length + nums2.length == 0) return 0;
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int low = 0;
        int high = nums1.length;
        while (low <= high) {
            int pos1 = low + ((high - low)>>1); // the cut position in nums1
            // for example, if  [/ 1 2 3], pos1 = 0; if [1 / 2 3], pos1 = 1.
            // if [1 2 3 /], pos1 = 3.
            
            // calculate the cut position in nums2, let the left two halves have (m+n)/2 numbers,
            // and the right two halves have m+n - (m+n)/2 numbers.
            // notice that m+n - (m+n)/2 may or may not be equal to (m+n)/2 !!!
            int pos2 = nums1.length + ((nums2.length - nums1.length)>>1) - pos1;
            
            int lower1 = (pos1 == 0)? Integer.MIN_VALUE : nums1[pos1 - 1];
            int upper1 = (pos1 == nums1.length)? Integer.MAX_VALUE : nums1[pos1];
            // int lower2 = (pos2 <= 0 || pos2 > nums2.length)? Integer.MIN_VALUE : nums2[pos2 - 1];
            int lower2 = (pos2 <= 0)? Integer.MIN_VALUE : nums2[pos2 - 1];
            int upper2 = (pos2 >= nums2.length)? Integer.MAX_VALUE : nums2[pos2];
            
            if (lower1 <= upper2 && lower2 <= upper1) {
                // we have a correct cut here, generate the result.
                int left = pos1 + pos2;
                int right = nums1.length + nums2.length - left;
                if (left == right) { // two halves have equal count of numbers.
                    double lowNum = Math.max(lower1, lower2);
                    double highNum = Math.min(upper1, upper2);
                    return (lowNum + highNum)/2;
                }
                else { // the right two halves have one more number than the left two halves.
                    return (double) Math.min(upper1, upper2);
                }
            }
            else if (lower1 > upper2) high = pos1;
            else low = pos1 + 1;
        }
        return -1;
    }
}
