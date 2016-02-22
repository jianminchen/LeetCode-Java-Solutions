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

        Iterator<Interval> iter = intervals.iterator();
        List<Interval> newInts = new ArrayList<>();
        
        if (intervals.size() == 0) {
            newInts.add(newInterval);
            return newInts;
        }
        
        Interval cur = null;
        while (iter.hasNext()) {
            cur = iter.next();
            if (newInterval.start > cur.end) {
                newInts.add(cur);   
            }
            else break;
        }
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
