/**
 * @see <a href="https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/">Verify Preorder Sequence in Binary Search Tree</a>
 */

public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return true;
        return verifyPreorder(preorder, 0, preorder.length - 1);
    }
    
    private boolean verifyPreorder(int[] preorder, int low, int high) {
        if(low >= high) return true;
        int i = low + 1;
        while (i <= high && preorder[low] > preorder[i]) ++i;
        if (i == high + 1) {
            return verifyPreorder(preorder, low + 1, high);
        } else {
            for (int j = i + 1; j <= high; ++j) {
                if (preorder[j] < preorder[low]) return false;
            }
            return verifyPreorder(preorder, low + 1, i - 1) 
                    && verifyPreorder(preorder, i, high);
        }
    }
}
