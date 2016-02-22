/**
 * @see <a href="https://leetcode.com/problems/two-sum-iii-data-structure-design/">Two Sum III - Data structure design</a>
 */

public class TwoSum {
    
    // Add the number to an internal data structure.
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    public void add(int number) {
        if (hm.containsKey(number)) hm.put(number, 2);
        else hm.put(number, 1);
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        Set<Integer> ks = hm.keySet();
        for (int i : ks) {
            if (hm.containsKey(value - i)) {
                if (i != value - i || (i == value - i && hm.get(i) >= 2)) return true;
            }
        }
        return false;
    }
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
