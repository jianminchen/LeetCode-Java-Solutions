/**
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 */

public class Solution {
    class BSTNode {
        int val;
        int lessCount, dupCount;
        BSTNode left, right;
        BSTNode(int value) {
            left = null;
            right = null;
            val = value;
            dupCount = 1;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        int[] res = new int[nums.length];
        BSTNode root = null;
        for (int i = nums.length - 1; i >= 0; --i) {
            root = insert(root, nums[i], i, res, 0);
        }
        List<Integer> finalRes = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) finalRes.add(res[i]);
        return finalRes;
    }
    private BSTNode insert(BSTNode node, int value, int i, int[] res, int prevLess) {
        if (node == null) {
            BSTNode newNode = new BSTNode(value);
            node = newNode;
            res[i] = prevLess;
        } else if (node.val == value) {
            ++node.dupCount;
            res[i] = prevLess + node.lessCount;
        } else if (value < node.val) {
            ++node.lessCount;
            node.left = insert(node.left, value, i, res, prevLess);
        } else {
            prevLess += node.lessCount + node.dupCount;
            node.right = insert(node.right, value, i, res, prevLess);
        }
        return node;
    }
}
