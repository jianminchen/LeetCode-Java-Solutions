/**
 * @see <a href="https://leetcode.com/problems/contains-duplicate-ii/">Contains Duplicate II</a>
 */

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // a hashMap stores an array of indices of the number.
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>();
        if (nums == null || nums.length == 0) return false;
        if (k <= 0) return false;
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])) hm.get(nums[i]).add(i);
            else {
                ArrayList<Integer> al = new ArrayList<Integer>();
                al.add(i);
                hm.put(nums[i], al);
            }
        }

        Set<Map.Entry<Integer, ArrayList<Integer>>> set = hm.entrySet();
        for (Map.Entry<Integer, ArrayList<Integer>> entry : set) {
            Collections.sort(entry.getValue());
            for (int i = 1; i < entry.getValue().size(); i ++) {
                if (entry.getValue().get(i) - entry.getValue().get(i-1) <= k) return true;
            }
        }
        return false;
    }
}
