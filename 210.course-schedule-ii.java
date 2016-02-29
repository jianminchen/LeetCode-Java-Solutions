/**
 * @see <a href="https://leetcode.com/problems/course-schedule-ii/">Course Schedule II</a>
 */

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> dpList = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            dpList.add(new ArrayList<Integer>());
        }
        // get dependency list and indegree
        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; ++i) {
            dpList.get(prerequisites[i][1]).add(prerequisites[i][0]);
            ++indegree[prerequisites[i][0]];
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (indegree[i] == 0) q.add(i);
        }
        // take courses
        int[] result = new int[numCourses];
        int i = 0;
        while (!q.isEmpty()) {
            int toTake = q.remove();
            result[i++] = toTake;
            for (int c : dpList.get(toTake)) {
                --indegree[c];
                if (indegree[c] == 0) q.add(c);
            }
        }
        if (i != numCourses) return new int[0]; // haven't taken all courses
        return result;
    }
}
