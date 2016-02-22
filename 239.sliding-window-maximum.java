/**
 * @see <a href="https://leetcode.com/problems/sliding-window-maximum/">Sliding Window Maximum</a>
 */

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[0];
        if (nums == null || nums.length == 0 || k == 0) return res;
        res = res = new int[nums.length - k + 1];
        Deque<Integer> list = new LinkedList<>();
        for (int i = 0; i < k; ++i) {
            addToList(list, nums[i]);
        }
        res[0] = list.getFirst();
        for (int i = k; i < nums.length; ++i) {
            if (nums[i-k] == res[i - k]) list.removeFirst();
            addToList(list, nums[i]);
            res[i - k + 1] = list.getFirst();
        }
        return res;
    }
    public void addToList(Deque<Integer> list, int num) {
        while (list.size() != 0 && num > list.getLast()) list.removeLast();
        list.add(num);
    }
}
