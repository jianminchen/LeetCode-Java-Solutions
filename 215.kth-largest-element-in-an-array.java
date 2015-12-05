/**
 * @see <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/">Kth Largest Element in an Array</a>
 */

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        /*
        int newNum[] = new int[nums.length];
        for (int i = 0; i < newNum.length; ++i) {
            newNum[i] = nums[i];
        }
        Arrays.sort(newNum);
        return newNum[newNum.length - k];
        */
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; ++i) {
            pq.add(nums[i]);
        }
        for (int i = k; i < nums.length; ++i) {
            if (nums[i] < pq.peek()) ;
            else {
                pq.remove();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }
}
