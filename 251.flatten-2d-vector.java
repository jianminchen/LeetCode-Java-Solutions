/**
 * @see <a href="https://leetcode.com/problems/flatten-2d-vector/">Flatten 2D Vector</a>
 */

public class Vector2D {
    private List<Integer> totalList;
    private int ci;
    public Vector2D(List<List<Integer>> vec2d) {
        totalList = new ArrayList<Integer>();
        for (List<Integer> aList : vec2d) {
            for (Integer i : aList) {
                totalList.add(i);
            }
        }
        ci = 0;
    }

    public int next() {
        int returnValue = totalList.get(ci);
        ++ci;
        return returnValue;
    }

    public boolean hasNext() {
        return ci < totalList.size();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
