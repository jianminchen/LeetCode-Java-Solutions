/**
 * @see <a href="https://leetcode.com/problems/merge-sorted-array/">Merge Sorted Array</a>
 */

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int i = m - 1, j = n - 1;
        
        // how to simplify the code: first, multiple index -- can be used just once at the end of the while loop.
        // second: the first case and the third case, operations are the same; the second case and the fourth case are the same; ==> can combined them!
        /*
        while (i >= 0 || j >= 0) {
            if (i < 0) {
                nums1[index] = nums2[j];
                index --; 
                j --;
            }
            else if (j < 0) {
                nums1[index] = nums1[i];
                index --;
                i --;
            }
            else if (nums1[i] <= nums2[j]) {
                nums1[index] = nums2[j];
                index --; 
                j --;
            }
            else { // nums1[i] > nums2[j]
                nums1[index] = nums1[i];
                index --; 
                i --;
            }
        }
        */
        while (i >= 0 || j >= 0) {
            if (i < 0 || (i >= 0 && j >= 0 && nums1[i] < nums2[j])) {
                nums1[index] = nums2[j];
                j --;
            }
            else {
                nums1[index] = nums1[i];
                i --;
            }
            index --;
        }
    }
}
