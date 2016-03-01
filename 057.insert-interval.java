/**
 * @see <a href="https://leetcode.com/problems/insert-interval/">Insert Interval</a>
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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || newInterval == null) throw new NullPointerException();
        List<Interval> result = new ArrayList<>();
        boolean newIntervalAdded = false;
        for (int i = 0; i < intervals.size(); ++i) {
            if (!newIntervalAdded && intervals.get(i).start > newInterval.start) {
                addInterval(result, newInterval);
                newIntervalAdded = true;
                --i; // we need to reconsider the current interval
            } else {
                addInterval(result, intervals.get(i));
            }
        }
        if (!newIntervalAdded) { // if the newInterval haven't been added, we add it at last
            addInterval(result, newInterval);
        }
        return result;
    }
    
    // the newInterval has a starting time that is greater than the last interval's starting time in intervals
    private void addInterval(List<Interval> intervals, Interval newInterval) {
        if (intervals.size() == 0 || newInterval.start > intervals.get(intervals.size() - 1).end) {
            intervals.add(newInterval);
        } else {
            intervals.get(intervals.size() - 1).end = 
                    Math.max(intervals.get(intervals.size() - 1).end, newInterval.end);
        }
    }
}
