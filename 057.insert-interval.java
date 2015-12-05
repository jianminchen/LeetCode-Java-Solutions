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
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        /*
        if (newInterval.end < intervals.get(0).start) {
            intervals.add(0, newInterval); return intervals;
        }
        if (newInterval.start > intervals.get(intervals.size() - 1).end) {
            intervals.add(newInterval); return intervals;
        }
        int i = intervals.length - 1;
        while (i >= 0 && newInterval.start < intervals.get(i).start) --i;
        int startAfter = i;
        i = 0;
        while (i <= intervals.length - 1 && newInterval.end > intervals.get(i).end) ++i;
        int endBefore = i;
        */
        Iterator<Interval> iter = intervals.iterator();
        List<Interval> newInts = new ArrayList<>();
        
        if (intervals.size() == 0) {
            newInts.add(newInterval);
            return newInts;
        }
        
        Interval cur = null; // initialization required !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        while (iter.hasNext()) {
            cur = iter.next();
            if (newInterval.start > cur.end) {
                newInts.add(cur);   
            }
            else break;
        }
        // wrong answer for input [1, 5], [6, 8].
        // wrong answer for input [[1,5]] [2,3]
        if (!iter.hasNext()) {
            if (newInterval.end < cur.start) {
                newInts.add(newInterval);
                newInts.add(cur);
                return newInts;
            }
            else if (newInterval.end <= cur.end) {
                if (newInterval.start < cur.start) {
                    newInts.add(new Interval(newInterval.start, cur.end));
                }
                else {
                    newInts.add(new Interval(cur.start, cur.end));
                }
                return newInts;
            }
            else { // newInterval.end > cur.end;
                if (newInterval.start > cur.end) {
                    // wrong answer for: [[1,5], [6,8]]
                    // Output:
                    // [[1,5],[1,5],[6,8]]
                    // Expected:
                    // [[1,5],[6,8]]

                    // newInts.add(cur);
                    newInts.add(newInterval);
                    return newInts;
                }
                else { // newInterval.start <= cur.end
                    newInts.add(new Interval(Math.min(newInterval.start, cur.start), newInterval.end));
                    return newInts;
                }
            }

        }
        
        int newStart = 0, newEnd = 0;
        if (newInterval.start < cur.start) newStart = newInterval.start;
        else newStart = cur.start;
        
        do {
            if (newInterval.end > cur.end && iter.hasNext()) {
                cur = iter.next();
            }
            else {
                break;
            }
        } while (iter.hasNext());
        
        /*if (!iter.hasNext()) {
            newInts.add(new Interval(newStart, Math.max(cur.end, newInterval.end)));
            return newInts;
        }
        */
        if (newInterval.end < cur.start) {
            newEnd = newInterval.end;
            newInts.add(new Interval(newStart, newEnd));
            newInts.add(cur);
        }
        else if (newInterval.end >= cur.end) {
            newEnd = newInterval.end;
            newInts.add(new Interval(newStart, newEnd));
            // covers cur.
        }
        else { // newInterval.end >= cur.start, < cur.end;
            newEnd = cur.end;
            newInts.add(new Interval(newStart, newEnd));
        }
        
        while (iter.hasNext()) {
            newInts.add(iter.next());
        }
        return newInts;
    }
}
