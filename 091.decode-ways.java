/**
 * @see <a href="https://leetcode.com/problems/decode-ways/">Decode Ways</a>
 */

public class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        if (s.equals("0")) return 0;
        int[] ways = new int[s.length() + 1];
        
        
        ways[s.length()] = 1;
        if (s.charAt(s.length() - 1) == '0') {
            ways[s.length() - 1] = 0;
        } else {
            ways[s.length() - 1] = 1;
        }        
        for (int i = s.length() - 2; i >= 0; --i) {
            if (s.charAt(i) == '0') {
                ways[i] = 0;
            } else {
                int num = Integer.parseInt(s.substring(i, i + 2));
                if (num > 26) {
                    ways[i] = ways[i + 1];
                } else {
                    ways[i] = ways[i + 1] + ways[i + 2];
                }
            }
        }
        return ways[0];
    }
}
