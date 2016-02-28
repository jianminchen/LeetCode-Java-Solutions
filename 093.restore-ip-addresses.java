/**
 * @see <a href="https://leetcode.com/problems/restore-ip-addresses/">Restore IP Addresses</a>
 */

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(s, 4, new ArrayList<String>(), res);
        return res;
    }
    
    private void helper(String s, int remain, List<String> path, List<String> res) {
        if (s.length() > remain * 3 || s.length() < remain) return;
        if (remain == 0) {
            if (s.length() == 0) {
                StringBuilder aRes = new StringBuilder(path.get(0));
                for (int i = 1; i < path.size(); ++i) {
                    aRes.append("."); 
                    aRes.append(path.get(i));
                }
                res.add(new String(aRes));
            }
        } else { // remain != 0
            if (s.charAt(0) == '0') {
                path.add("0");
                helper(s.substring(1), remain - 1, path, res);
                path.remove(path.size() - 1);
            } else {
                for (int i = 1; i <= Math.min(3, s.length()); ++i) {
                    // do not need to check for two digit numbers.
                    if (i <= 2 || Integer.parseInt(s.substring(0, i)) <= 255) {
                        path.add(s.substring(0, i));
                        helper(s.substring(i), remain - 1, path, res);
                        path.remove(path.size() - 1);
                    }
                }
            }
        }
    }
}
