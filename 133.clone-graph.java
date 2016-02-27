/**
 * @see <a href="https://leetcode.com/problems/clone-graph/">Clone Graph</a>
 */

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *   int label;
 *   List<UndirectedGraphNode> neighbors;
 *   UndirectedGraphNode(int x) { 
 *     label = x;
 *     neighbors = new ArrayList<UndirectedGraphNode>();
 *   }
 * }
 */

public class Solution {
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if (node == null) {
      return null;
    }
    Map<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<>();
    Queue<UndirectedGraphNode> q = new LinkedList<>();
    q.add(node);
    while (!q.isEmpty()) {
      UndirectedGraphNode cur = q.remove();
      if (!hm.containsKey(cur)) { // consider the current node itself
        UndirectedGraphNode newCur = new UndirectedGraphNode(cur.label);
        hm.put(cur, newCur);
      }
      for (UndirectedGraphNode n : cur.neighbors) { // consider the neighbors
        if (hm.containsKey(n)) {
          hm.get(cur).neighbors.add(hm.get(n));
        } else {
          UndirectedGraphNode newNode = new UndirectedGraphNode(n.label);
          hm.put(n, newNode);
          hm.get(cur).neighbors.add(newNode);
          q.add(n);
        }
      }
    }
    return hm.get(node);
  }
}
