/**
 * @see <a href="https://leetcode.com/problems/restore-ip-addresses/">Restore IP Addresses</a>
 */

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        List<List<String>> intermediate = restoreIpAddresses(s, 4);
        for (List<String> aList : intermediate) {
            StringBuilder sb = new StringBuilder();
            sb.append(aList.get(0));
            for (int i = 1; i < aList.size(); ++i) {
                sb.append('.');
                sb.append(aList.get(i));
            }
            res.add(new String(sb));
        }
        return res;
    }
    
    public List<List<String>> restoreIpAddresses(String s, int n) {
        List<List<String>> res = new ArrayList<>();
        if (s.length() < n || s.length() > 3 * n) return res;
        if (n == 1) {
            if (s.length() > 1 && s.charAt(0) == '0') return res;
            if (Integer.parseInt(s) > 255) return res;
            else {
                List<String> aList = new ArrayList<>();
                aList.add(s);
                res.add(aList);
                return res;
            }
        }
        else {
            if (s.charAt(0) == '0') {
                for (List<String> aList : restoreIpAddresses(s.substring(1), n - 1)) {
                    List<String> newList = new ArrayList<>();
                    newList.add("0");
                    newList.addAll(aList);
                    res.add(newList);
                }
            }
            else {
                for (int i = 1; i <= 3 && i <= s.length(); ++i) {
                    if (Integer.parseInt(s.substring(0, i)) <= 255) {
                        for (List<String> aList : restoreIpAddresses(s.substring(i), n - 1)) {
                            List<String> newList = new ArrayList<>();
                            newList.add(s.substring(0, i));
                            newList.addAll(aList);
                            res.add(newList);
                        }
                    }
                }

            }
            return res;
        }
    }
}
