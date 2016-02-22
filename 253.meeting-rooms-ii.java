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
        int[] bound = new int[intervals.length * 2];
        for (int i = 0; i < intervals.length; ++i) {
            bound[2 * i] = intervals[i].start;
            bound[2 * i + 1] = intervals[i].end;
        }
        Arrays.sort(bound);
        int min = 0;
        for (int i = 1; i < bound.length; ++i) {
            Interval newInter = new Interval(bound[i - 1], bound[i]);
            int overlap = 0;
            for (int j = 0; j < intervals.length; ++j) {
                if (conflict(newInter, intervals[j])) ++overlap;
            }
            min = Math.max(min, overlap);
        }
        return min;
    }
    
    public boolean conflict(Interval ia, Interval ib) {
        if (ia.end <= ib.start || ia.start>= ib.end) return false;
        else return true;
    }
}
