/**
 * @see <a href="https://leetcode.com/problems/ugly-number-ii/">Ugly Number II</a>
 */

// this is the PriorityQueue solution
// a better solution is to us dp, with O(n)
public class Solution {
    public int nthUglyNumber(int n) {
        int count = 0;
        long prev = -1;
        PriorityQueue<Long> pq = new PriorityQueue<Long>();
        pq.add(1L);
        while (count < n) {
            while (pq.peek() == prev) {
                pq.remove();
            }
            long num = pq.remove();
            prev = num;
            ++count;
            if (count == n) return (int) num;

            pq.add(num * 2);
            pq.add(num * 3);
            pq.add(num * 5);
        }
        return -1;
    }
}
