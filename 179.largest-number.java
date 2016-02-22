/**
 * @see <a href="https://leetcode.com/problems/largest-number/">Largest Number</a>
 */

public class Solution {
    class MyNumber implements Comparable<MyNumber> {
        public int val;
        public MyNumber(int v) {
            val = v;
        }
        public int compareTo(MyNumber m) {
            String s1 = new Integer(val).toString();
            String s2 = new Integer(m.val).toString();
            String s1s2 = s1 + s2;
            String s2s1 = s2 + s1;
            for (int i = 0; i < s1s2.length(); ++i) {
                if (s1s2.charAt(i) > s2s1.charAt(i)) return -1;
                else if (s1s2.charAt(i) < s2s1.charAt(i)) return 1;
            }
            return 0;
        }
    }
    
    public String largestNumber(int[] nums) {
        List<MyNumber> list = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            MyNumber newNum = new MyNumber(nums[i]);
            list.add(newNum);
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); ++i) {
            sb.append(list.get(i).val);
        }
        
        String res = new String(sb);
        boolean allZero = true;
        for (int i = 0; i < res.length(); ++i) {
            if (res.charAt(i) != '0') {
                allZero = false;
                break;
            }
        }
        if (allZero) return "0";
        return res;
    }
}
