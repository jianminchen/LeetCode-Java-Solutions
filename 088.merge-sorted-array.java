/**
 * @see <a href="https://leetcode.com/problems/merge-sorted-array/">Merge Sorted Array</a>
 */

public class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    if (nums1 == null || nums2 == null) {
      throw new NullPointerException();
    }
    int fillIndex = m + n - 1;
    int i = m - 1, j = n - 1;
    while (fillIndex >= 0) {
      if (i < 0 || (j >= 0 && nums1[i] < nums2[j])) {
        nums1[fillIndex--] = nums2[j--];
      } else {
        nums1[fillIndex--] = nums1[i--];
      }
    }
  }
}
