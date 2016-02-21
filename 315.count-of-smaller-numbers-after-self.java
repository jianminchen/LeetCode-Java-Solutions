public class Solution {
    class BSTNode {
        public int val;
        public int lessCount, dupCount;
        public BSTNode left, right;
        public BSTNode(int value) {
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
        // the following line: incompatible types: inference variable T has incompatible bounds
        // return Arrays.asList(res);
        List<Integer> finalRes = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) finalRes.add(res[i]);
        return finalRes;
    }
    public BSTNode insert(BSTNode node, int value, int i, int[] res, int prevLess) {
        if (node == null) {
            BSTNode newNode = new BSTNode(value);
            node = newNode;
            // System.out.println(node.dupCount);
            res[i] = prevLess;
        }
        else if (node.val == value) {
            ++node.dupCount;
            // the following is wrong !!!!
            // res[i] = prevLess;
            res[i] = prevLess + node.lessCount;
        }
        else if (value < node.val) {
            ++node.lessCount;
            // note that the folling line will not set the node.left, thus, will have wrong answer !!!!!!!!!!!!!!!!
            // insert(node.left, value, i, res,  prevLess);
            node.left = insert(node.left, value, i, res, prevLess);
        }
        else { // value > node.val
            // without this line, wrong answer !!!
            prevLess += node.lessCount + node.dupCount;
            // System.out.println(prevLess);
            // the following line will not set the node.right, thus, will have wrong answer !!!!!!!!!!!!!!!!!!!!!
            // insert(node.right, value, i, res, prevLess);
            node.right = insert(node.right, value, i, res, prevLess);
        }
        return node;
    }
}
