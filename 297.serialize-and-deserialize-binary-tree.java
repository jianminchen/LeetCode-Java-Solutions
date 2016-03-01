/**
 * @see <a href="https://leetcode.com/problems/serialize-and-deserialize-binary-tree/">Serialize and Deserialize Binary Tree</a>
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
 
// use an array to store a tree node;
// array[0] = value;
// array[1] = li, // left child index, if null, -1
// array[2] = ri, // right child index, if null, -1
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // nodes will be added to an arrayList of arrays; then, convert the arraylist to a string.
        if (root == null) return new String();
        List<int[]> list = new ArrayList<int[]>();
        Stack<TreeNode> stk = new Stack<TreeNode>();
        Stack<Integer> iStk = new Stack<Integer>();
        TreeNode cur = root;
        int ci = 0;
        while (true) { // preorder traversal to construct the arraylist
            while (cur != null) {
                if (!stk.isEmpty()) { // get the parent, and set the left and right of the parent.
                    int pi = iStk.peek(); // ci is the current index
                    if (cur == stk.peek().left) { // cur is left child of the parent
                        list.get(pi)[1] = ci;
                    } else { // cur is the right child of the parent
                        list.get(pi)[2] = ci;
                    }
                }
                list.add(new int[]{cur.val, -1, -1});
                stk.push(cur);
                iStk.push(ci);
                cur = cur.left;
                ++ci;
            }
            while (!stk.isEmpty() && (stk.peek().right == null || stk.peek().right == cur)) {
                cur = stk.pop();
                iStk.pop();
            }
            if (stk.isEmpty()) break;
            else cur = stk.peek().right;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); ++i) {
            for (int j = 0; j < 3; ++j) {
                sb.append(list.get(i)[j]);
                sb.append(' ');
            }
        }
        return new String(sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // convert the string into an arrayList; then, reconstruct the tree using the arraylist.
        if (data.length() == 0) return null;
        List<Integer> li = new ArrayList<Integer>();
        int i = 0;
        while (i < data.length()) {
            int si = i;
            while (data.charAt(i) != ' ') ++i;
            int ei = i;
            li.add(Integer.parseInt(data.substring(si, ei)));
            ++i;
        }
        List<int[]> list = new ArrayList<int[]>();
        for (int k = 0; k < li.size()/3; ++k) {
            int[] node = new int[3];
            for (int j = 0; j < 3; ++j) {
                node[j] = li.get(k * 3 + j);
            }
            list.add(node);
        }
        // reconstruct the tree using the list of arrays.
        TreeNode root = generateTree(list, 0);
        return root;
    }
    
    private TreeNode generateTree(List<int[]> list, int index) {
        TreeNode node = new TreeNode(list.get(index)[0]);
        node.left = list.get(index)[1] == -1 ? null : generateTree(list, list.get(index)[1]);
        node.right = list.get(index)[2] == -1 ? null: generateTree(list, list.get(index)[2]);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
