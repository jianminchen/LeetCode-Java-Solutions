/**
 * @see <a href="https://leetcode.com/problems/merge-intervals/">Merge Intervals</a>
 */

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    // don't forget the class identifier.
    private static class MyComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval it1, Interval it2) {
            return it1.start - it2.start;
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null) throw new NullPointerException();
        List<Interval> res = new ArrayList<>();
        Collections.sort(intervals, new MyComparator());
        Iterator<Interval> iter = intervals.iterator();
        if (iter.hasNext()) res.add(iter.next());
        while (iter.hasNext()) {
            Interval cur = iter.next();
            if (cur.start > res.get(res.size() - 1).end) {
                res.add(cur);
            } else { // cur.start <= res.get(res.size() - 1).end
                int newEnd = Math.max(res.get(res.size() - 1).end, cur.end);
                res.get(res.size() - 1).end = newEnd;
            }
        }
        return res;
    }
}
