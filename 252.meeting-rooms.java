/**
 * @see <a href="https://leetcode.com/problems/meeting-rooms/">Meeting Rooms</a>
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
    public class MyInterval extends Interval implements Comparable<MyInterval> {
        public MyInterval(int s, int e) {
            start = s;
            end = e;
        }
        @Override
        public int compareTo(MyInterval mi) {
            if (start < mi.start) return -1;
            else if (start == mi.start) return 0;
            else return 1;
        }
    }
    public boolean canAttendMeetings(Interval[] intervals) {
        MyInterval[] mis = new MyInterval[intervals.length];
        for (int i = 0; i < intervals.length; i ++) {
            mis[i] = new MyInterval(intervals[i].start, intervals[i].end);
        }
        Arrays.sort(mis);
        for (int i = 1; i < mis.length; i ++) {
            if (mis[i].start < mis[i-1].end) return false;
        }
        return true;
    }
}
