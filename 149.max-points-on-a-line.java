/**
 * @see <a href="https://leetcode.com/problems/max-points-on-a-line/">Max Points on a Line</a>
 */

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) return 0;
        // key is the point, and value is the count of the point.
        Map<List<Integer>, Integer> hm = new HashMap<>();
        for (int i = 0; i < points.length; ++i) {
            List<Integer> myPoint = new ArrayList<>();
            myPoint.add(points[i].x);
            myPoint.add(points[i].y);
            if (hm.containsKey(myPoint)) {
                hm.put(myPoint, hm.get(myPoint) + 1);
            } else {
                hm.put(myPoint, 1);
            }
        }
        if (hm.size() == 1) {
            for (List<Integer> p : hm.keySet()) {
                return hm.get(p);
            }
        }
        int max = 1;
        for(List<Integer> p1 : hm.keySet()) {
            for (List<Integer> p2 : hm.keySet()) {
                if (p2 != p1) {
                    int x1 = p1.get(0);
                    int y1 = p1.get(1);
                    int x2 = p2.get(0);
                    int y2 = p2.get(1);
                    int maxPoints = hm.get(p1) + hm.get(p2);
                    for (List<Integer> p3 : hm.keySet()) {
                        if (p3 != p2 && p3 != p1) {
                            int x = p3.get(0);
                            int y = p3.get(1);
                            if ((x - x1) * (y2 - y1) == (y - y1) * (x2 - x1)) {
                                maxPoints += hm.get(p3);
                            }
                        }
                    }
                    max = Math.max(max, maxPoints);
                }
            }
        }
        return max;
    }
}
