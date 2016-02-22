/**
 * @see <a href="https://leetcode.com/problems/course-schedule-ii/">Course Schedule II</a>
 */

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Set<Integer>> dependList = getDependList(numCourses, prerequisites);
        boolean[] courseTaken = new boolean[numCourses];
        
        int[] order = new int[numCourses];
        int index = 0;
        
        int taken = 0;
        while (taken < numCourses) {
            int toTake = 0;
            for (int i = 0; i < numCourses; ++i) {
                if (courseTaken[i] == false && dependList.get(i).size() == 0) {
                    ++toTake;
                    courseTaken[i] = true;
                    
                    order[index] = i;
                    ++index;
                    // update other dependencies;
                    for (int j = 0; j < numCourses; ++j) {
                        if (dependList.get(j).contains(i)) {
                            dependList.get(j).remove(i);
                        }
                    }
                }
            }
            if (toTake == 0) {
                return new int[0];
            }
            taken += toTake;
        }
        return order;
        
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
