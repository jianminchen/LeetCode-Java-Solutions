/**
 * @see <a href="https://leetcode.com/problems/search-in-rotated-sorted-array-ii/">Search in Rotated Sorted Array II</a>
 */

public class Solution {
    public boolean search(int[] nums, int target) {
        // what's the time complexity?
        // worst case O(n), average case O(logn).
        // what can we know for sure???
        int low = 0;
        int high = nums.length - 1;
        while (true) {
            if (low > high) return false;
            /*if (low == high) {
                if (target == nums[low]) return true;
                else return false;
            } */
            int mid = low + ((high - low)>>1);
            if (target == nums[low]) return true;
            if (target == nums[high]) return true;
            if (target == nums[mid]) return true;
            
            if (nums[mid] > nums[high]) {
                if (target > nums[mid]) {
                    low = mid + 1;
                }
                else {
                    // target < nums[mid]
                    ++low;
                    --high;
                }
            }
            else if (nums[mid] < nums[low]) {
                if (target < nums[mid]) {
                    high = mid - 1;
                }
                else { // target > nums[mid]
                    --high;
                    ++low;
                }
            }
            else { // without this else branch, we will have time limit exceeded error,
                   // the while loop will loop forever!!!!!
                ++low;
                --high;
            }
        }
        // if with the following line: unreachable statement!!!!!!!!
        // return false;
    }
}

// what is for sure in a rotated sorted array with duplicats.??
// there is a way in to partion the sorted array into two parts
// such that, put the first part in front of the second, or put the first part after the second part,
// we can have a sorted array. 
// go through some cases to determine the right logic.
// use examples that can cover many differant situations to make your
// logic work for various cases and thus, correct !!!!!!!!!
// 1 1 1 1 2 3 1 1 1, target: 4.
// 1 1 1 1 -4 -3 -2 1 1 1
