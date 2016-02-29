/**
 * @see <a href="https://leetcode.com/problems/find-the-celebrity/">Find the Celebrity</a>
 */

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        ArrayList<Integer> candidate = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            candidate.add(i);
        }
        while (candidate.size() >= 2) { // at the end, we will have only one candidate
            ArrayList<Integer> newCand = new ArrayList<Integer>();
            for (int i = 0; i < candidate.size() && i + 1 < candidate.size(); i = i + 2) {
                if (knows(candidate.get(i), candidate.get(i + 1))) {
                    newCand.add(candidate.get(i + 1));
                } else {
                    newCand.add(candidate.get(i));
                }
            }
            if (candidate.size() % 2 != 0) {
                newCand.add(candidate.get(candidate.size() - 1));
            }
            candidate = newCand;
        }
        // verify the candidate
        for (int i = 0; i < n; ++i) {
            if (i != candidate.get(0) && knows(candidate.get(0), i)) return -1;
        }
        for (int i = 0; i < n; ++i) {
            if (i != candidate.get(0) && !knows(i, candidate.get(0))) return -1;
        }
        return candidate.get(0);
    }
}
