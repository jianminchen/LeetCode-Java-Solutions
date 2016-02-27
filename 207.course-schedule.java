/**
 * @see <a href="https://leetcode.com/problems/course-schedule/">Course Schedule</a>
 */

public class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    if (numCourses < 0) {
      throw new IllegalArgumentException("numCourses should be non-negative.");
    }
    if (prerequisites == null || prerequisites.length == 0) {
      return true;
    }
    List<List<Integer>> dpList = getDependencyList(numCourses, prerequisites);
    boolean[] visited = new boolean[numCourses];
    int cur = 0;
    while (true) { // in each iteration, a dfs is conducted
      while (cur < visited.length && visited[cur]) {
        ++cur; // get next unvisited node
      }
      if (cur == numCourses) {
        break; // finished traversing
      }
      Set<Integer> curActive = new HashSet<>();
      if (dfsHelperHasCycle(cur, dpList, curActive, visited)) {
        return false;
      }
    }
    return true;
  }

  private List<List<Integer>> getDependencyList(int numCourses, 
      int[][] prerequisites) {
    List<List<Integer>> dpList = new ArrayList<>();
    for (int i = 0; i < numCourses; ++i) {
      dpList.add(new ArrayList<Integer>());         
    }
    for (int i = 0; i < prerequisites.length; ++i) {
      dpList.get(prerequisites[i][1]).add(prerequisites[i][0]);
    }
    return dpList;
  }

  private boolean dfsHelperHasCycle(int cur, List<List<Integer>> dpList, 
      Set<Integer> curActive, boolean[] visited) {
    visited[cur] = true;
    curActive.add(cur);
    for (int nb : dpList.get(cur)) {
      if (curActive.contains(nb)) {
        return true; // has cycle
      }
    }
    for (int nb : dpList.get(cur)) {
      if (!visited[nb] && dfsHelperHasCycle(nb, dpList, curActive, visited)) {
        return true;
      }
    }
    curActive.remove(cur); // restore such that it will not affect other paths
    return false;
  }
}
