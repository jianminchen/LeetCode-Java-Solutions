/**
 * @see <a href="https://leetcode.com/problems/find-median-from-data-stream/">Find Median from Data Stream</a>
 */

class MedianFinder {

    public PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    public PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    // Adds a number into the data structure.
    public void addNum(int num) {
        if (maxHeap.size() == 0) maxHeap.add(num);
        else if (minHeap.size() == 0) {
            if (maxHeap.peek() <= num) minHeap.add(num);
            else { // maxHeap.peek() > num;
                int larger = maxHeap.remove();
                maxHeap.add(num);
                minHeap.add(larger);
            }
        }
        else { // both heaps not empty. 
            if (maxHeap.size() == minHeap.size()) {
                if (num <= minHeap.peek()) maxHeap.add(num);
                else {
                    int fromMin = minHeap.remove();
                    minHeap.add(num);
                    maxHeap.add(fromMin);
                }
            }
            else if (maxHeap.size() == minHeap.size() + 1) {
                if (num >= maxHeap.peek()) minHeap.add(num);
                else { // num < maxHeap.peek()
                    int fromMax = maxHeap.remove();
                    minHeap.add(fromMax);
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
        }
        else return (double) maxHeap.peek();
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
