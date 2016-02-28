/**
 * @see <a href="https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/">Populating Next Right Pointers in Each Node II</a>
 */

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode layerHead = root;
        while (layerHead != null) {
            TreeLinkNode nextLayerHead = null;
            TreeLinkNode layerCur = layerHead; // traverse in the current layer
            TreeLinkNode nextLayerPrev = null; // modify in the next layer
            while (layerCur != null) {
                if (layerCur.left == null && layerCur.right == null) {}
                else {
                    if (layerCur.left != null && layerCur.right == null) { // left not null
                        if (nextLayerHead == null) {
                            nextLayerHead = layerCur.left;
                        } else {
                            nextLayerPrev.next = layerCur.left;
                        }
                        nextLayerPrev = layerCur.left;
                    } else if (layerCur.left == null && layerCur.right != null)  { // right not null
                        if (nextLayerHead == null) {
                            nextLayerHead = layerCur.right;
                        } else {
                            nextLayerPrev.next = layerCur.right;
                        }
                        nextLayerPrev = layerCur.right;
                    } else {// layerCur.left != null and layerCur.right != null
                        if (nextLayerHead == null) {
                            nextLayerHead = layerCur.left;
                        } else {
                            nextLayerPrev.next = layerCur.left;
                        }
                        layerCur.left.next = layerCur.right;
                        nextLayerPrev = layerCur.right;
                    }
                }
                layerCur = layerCur.next;
            }
            layerHead = nextLayerHead; // may or may not be null.
        }        
    }
}
