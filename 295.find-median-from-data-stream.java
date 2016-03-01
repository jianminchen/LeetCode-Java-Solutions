/**
 * @see <a href="https://leetcode.com/problems/find-median-from-data-stream/">Find Median from Data Stream</a>
 */

class MedianFinder {
    // using a minHeap and a maxHeap, numbers in the minHeap will be less than numbers in the maxHeap.
    // each heap will have roughly the same number of elements, and we can easily calculate the median using these two heaps
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public void addNum(int num) { // Adds a number into the data structure.
        if (maxHeap.size() == 0) {
            maxHeap.add(num);
        } else {
            if (maxHeap.size() == minHeap.size()) {
                if (num <= minHeap.peek()) {
                    maxHeap.add(num);
                } else { // we always have maxHeap.size() >= minHeap.size()
                    maxHeap.add(minHeap.remove());
                    minHeap.add(num);

                }
            } else { // maxheap.size() == minHeap.size() + 1
                if (num >= maxHeap.peek()) {
                    minHeap.add(num);
                } else { // num < maxHeap.peek()
                    minHeap.add(maxHeap.remove());
                    maxHeap.add(num);
                }
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            double low = (double) maxHeap.peek();
            double high = (double) minHeap.peek();
            return (low + high) / 2.0;
        } else {
            return (double) maxHeap.peek();
        }
    }
}

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
