/**
 * @see <a href="https://leetcode.com/problems/meeting-rooms-ii/">Meeting Rooms II</a>
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
    public int minMeetingRooms(Interval[] intervals) {
        // idea, sort all si, ei. say array[]. create an inteveral (array[i - 1], array[i])
        // check how many intervals from the existing intervals overlap with this new interval.
        // traverse all new intervals, and get the maximum number of overlapping interval
        // which will be the min number of Rooms required.
        int[] bound = new int[intervals.length * 2];
        for (int i = 0; i < intervals.length; ++i) {
            bound[2 * i] = intervals[i].start;
            bound[2 * i + 1] = intervals[i].end;
        }
        Arrays.sort(bound);
        int min = 0;
        for (int i = 1; i < bound.length; ++i) {
            // previously used new Interval(bound[i], bound[i - 1]); wrong !!!!!!!!!!!!1
            // start should be bound[i - 1], end should be bound[i].
            Interval newInter = new Interval(bound[i - 1], bound[i]);
            int overlap = 0;
            for (int j = 0; j < intervals.length; ++j) {
                if (conflict(newInter, intervals[j])) ++overlap;
            }
            // System.out.println(" Overlap: " + overlap);
            min = Math.max(min, overlap);
        }
        return min;
    }
    
    public boolean conflict(Interval ia, Interval ib) {
        if (ia.end <= ib.start || ia.start>= ib.end) return false;
        else return true;
    }
}
