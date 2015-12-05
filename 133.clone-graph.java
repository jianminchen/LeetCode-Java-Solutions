/**
 * @see <a href="https://leetcode.com/problems/clone-graph/">Clone Graph</a>
 */

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        
        // the hashMap means the mapping from nodes in the old graph, to the 
        // nodes in the new graph.
        Map<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<>();
        // UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        // hm.put(node, newNode); 
        // either use newNode, or use hm.get(node) is OK!!!!!!!!
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.add(node);
        
        while (!q.isEmpty()) {
            UndirectedGraphNode cur = q.remove(); // the first will be the input node.
            if (!hm.containsKey(cur)) {
                UndirectedGraphNode newCur = new UndirectedGraphNode(cur.label);
                hm.put(cur, newCur);
            }
            for (UndirectedGraphNode n : cur.neighbors) {
                if (hm.containsKey(n)) {
                    hm.get(cur).neighbors.add(hm.get(n));
                }
                else {
                    UndirectedGraphNode newN = new UndirectedGraphNode(n.label);
                    hm.put(n, newN);
                    hm.get(cur).neighbors.add(newN);
                    q.add(n);
                }
            }
        }
        return hm.get(node);
    }
}
