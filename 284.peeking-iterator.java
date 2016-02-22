/**
 * @see <a href="https://leetcode.com/problems/peeking-iterator/">Peeking Iterator</a>
 */

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    List<Integer> list;
    int ci;
    public PeekingIterator(Iterator<Integer> iterator) {
	// initialize any member here. 
	list = new ArrayList<>();
	while (iterator.hasNext()) {
	    list.add(iterator.next());
	}
	ci = 0;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return list.get(ci);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
	int val = list.get(ci);
	++ci;
	return val;
    }

    @Override
    public boolean hasNext() {
        return ci < list.size();
    }
}
