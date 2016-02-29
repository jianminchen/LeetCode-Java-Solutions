public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        String path = "";
        helper(res, path, num, target, 0, 0, 0);
        return res;
    }
    public void helper(List<String> res, String path, String num, int target, int pos, long eval, long multed) {
        if (pos == num.length()) {
            if (target == eval) {
                res.add(path);
            }
            return; // reach at the end.
        }
        for (int i = pos; i < num.length(); ++i) {
            if (i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                // initialize. such that multed will not be zero.
                helper(res, path + num.substring(pos, i + 1), num, target, i + 1, cur, cur); 
            } else {
                helper(res, path + "+" + cur, num, target, i + 1, eval + cur, cur);
                helper(res, path + "-" + cur, num, target, i + 1, eval - cur, -cur);
                helper(res, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur);
            }
            
        }
    }
}
