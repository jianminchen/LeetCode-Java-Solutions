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
        int mid = low + ((high - low)>>1); // if you want to use shift for dividing by 2.
        // you need to use the braces!!!!!!!!!!!!!!!!!!!!!
        // shifting has the lowest priority!!!!!!!!!!!!!!!!!!!!!!
        if (target == numbers[mid]) return mid;
        else if (target < numbers[mid]) return find(numbers, low, mid - 1, target);
        else return find(numbers, mid + 1, high, target);
    }
    
    
    // method 2: two pointers.
    /*
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        int[] res = new int[2];
        while (i < j) {
            if (numbers[i] + numbers[j] < target) i ++;
            else if (numbers[i] + numbers[j] > target) j --;
            else {
                res[0] = i + 1; // index is not zero based !!!!!!!!!!!!!!!!!!
                res[1] = j + 1; // index is not zero based !!!!!!!!!!!!!!!!!!
                break;
            }
        }
        return res;
    }
    */
}
