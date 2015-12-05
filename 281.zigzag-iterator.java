/**
 * @see <a href="https://leetcode.com/problems/zigzag-iterator/">Zigzag Iterator</a>
 */

public class ZigzagIterator {
    public int curIndex;
    public int length;
    public int shortLength;
    public List<Integer> list1;
    public List<Integer> list2;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        curIndex = 0;
        
        // do we need to create new ArrayList for the lists??????
        // if the v1, and v2 are implemented by LinkedList, 
        // our iterator method will be more time consuming if we do not create arrayList for them.
        
        // we can't reverse the order of the lists!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        // the first is the first, and the second must be the second !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        // how can you make such mistakes????????????????????????????????????????????????????????????????????????????????????
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
            }
            else {
                return list2.get(prevIndex/2);
            }
        }
        else { // prevIndex > 2 * short length
            if (list1.size() > list2.size())
                return list1.get(prevIndex - shortLength);
            else {
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
