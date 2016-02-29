/**
 * @see <a href="https://leetcode.com/problems/zigzag-iterator/">Zigzag Iterator</a>
 */

public class ZigzagIterator {
    private int curIndex;
    private int length;
    private int shortLength;
    private List<Integer> list1;
    private List<Integer> list2;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        curIndex = 0;
        list1 = new ArrayList<Integer>(v1);
        list2 = new ArrayList<Integer>(v2);
        length = list1.size() + list2.size();
        shortLength = Math.min(list1.size(), list2.size());
    }

    public int next() {
        int prevIndex = curIndex;
        curIndex ++;
        if (prevIndex <= 2*shortLength - 1) {
            if (prevIndex % 2 == 0) {
                return list1.get(prevIndex/2);
            } else {
                return list2.get(prevIndex/2);
            }
        } else { // prevIndex > 2 * short length
            if (list1.size() > list2.size()) {
                return list1.get(prevIndex - shortLength);
            } else {
                return list2.get(prevIndex - shortLength);
            }
        }
    }

    public boolean hasNext() {
        return curIndex < length;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
