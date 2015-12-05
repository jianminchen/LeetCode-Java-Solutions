/**
 * @see <a href="https://leetcode.com/problems/course-schedule/">Course Schedule</a>
 */

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Set<Integer>> dependList = getDependList(numCourses, prerequisites);
        boolean[] courseTaken = new boolean[numCourses];
        int taken = 0;
        while (taken < numCourses) {
            int toTake = 0;
            for (int i = 0; i < numCourses; ++i) {
                if (courseTaken[i] == false && dependList.get(i).size() == 0) {
                    ++toTake;
                    courseTaken[i] = true;
                    // update other dependencies;
                    for (int j = 0; j < numCourses; ++j) {
                        if (dependList.get(j).contains(i)) {
                            dependList.get(j).remove(i);
                        }
                    }
                }
            }
            if (toTake == 0) return false;
            taken += toTake; // need to update, otherwise, will continue when taken == numCourses, will return false;
        }
        return true;
        
    }
    public List<Set<Integer>> getDependList(int numCourses, int[][] prerequisites) {
        List<Set<Integer>> dependList = new ArrayList<>();
        for (int i = 0; i <numCourses; ++i) {
            Set<Integer> set = new HashSet<Integer>();
            dependList.add(set);
        }
        for (int i = 0; i < prerequisites.length; ++i) {
            dependList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        return dependList;
    }
}
