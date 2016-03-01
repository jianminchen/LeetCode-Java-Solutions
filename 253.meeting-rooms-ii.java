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
    // we need to find the interval or a point with maximum overlapping intervals
    // two O(nlogn) solutions
    // 1. sort the start points and the end points, then at each point, the number of overlapping intervals is 
    //      the number of start points minus the number of end points
    // 2. greedy solution using minHeap
    // notice that [0, 5] and [5, 10] is not considered as overlapping
    private class Point implements Comparable<Point> {
        public int val;
        public boolean isStart;
        public Point(int v, boolean start) {
            val = v;
            isStart = start;
        }
        @Override
        public int compareTo(Point p) {
            if (val - p.val < 0) {
                return -1;
            } else if (val - p.val > 0) {
                return 1;
            } else {
                // make sure when points overlap, the end point is sorted before the start point
                if (isStart == false) return -1;
                else return 1;
            }
        }
    }
    
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null) throw new NullPointerException();
        if (intervals.length == 0) return 0;
        List<Point> lp = new ArrayList<>();
        for (int i = 0; i < intervals.length; ++i) {
            lp.add(new Point(intervals[i].start, true));
            lp.add(new Point(intervals[i].end, false));
        }
        Collections.sort(lp);
        int startN = 0, endN = 0, max = 0;
        for (int i = 0; i < lp.size(); ++i) {
            System.out.println(lp.get(i).val);
            max = Math.max(max, startN - endN);
            if (lp.get(i).isStart) ++startN;
            else ++endN;
        }
        return max;
    }
}
