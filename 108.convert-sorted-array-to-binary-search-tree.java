/**
 * @see <a href="https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/">Convert Sorted Array to Binary Search Tree</a>
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
    public TreeNode sortedArrayToBST(int[] nums, int low, int high) {
        // if we include this, low == high will not be a special case,
        // and can be included in the general cases.
        // but the number of recursive calls will be increased.
        if (low > high) return null;
        // so it's better to return directly for this "special" case?
        if (low == high) return new TreeNode(nums[low]);
        
        int mid = low + ((high - low)>>1);
        TreeNode left = sortedArrayToBST(nums, low, mid - 1);
        TreeNode right = sortedArrayToBST(nums, mid + 1, high);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = left;
        root.right = right;
        return root;
    }
}
