/**
 * @see <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">Two Sum II - Input array is sorted</a>
 */

public class Solution {
    
    // method 1: binary search
    
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for (int i = 0; i < numbers.length - 1; i ++) {
            int index2 = find(numbers, i + 1, numbers.length - 1, target - numbers[i]);
            if (index2 != -1) {
                res[0] = i + 1;
                res[1] = index2 + 1;
                break;
            }
        }
        return res;
    }
    public int find(int[] numbers, int low, int high, int target) {
        if (target < numbers[low] || target > numbers[high]) return -1;
        int mid = low + ((high - low)>>1);
        if (target == numbers[mid]) return mid;
        else if (target < numbers[mid]) return find(numbers, low, mid - 1, target);
        else return find(numbers, mid + 1, high, target);
    }
    
}
