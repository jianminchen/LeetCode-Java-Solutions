public class Solution {
    public String shortestPalindrome(String s) {
        if (s.length() <= 1) return s;
        int k = 0;
        int j = 1;
        String ns = s + "#" + new StringBuilder(s).reverse();
        int[] fail = new int[ns.length()];
        while (j < ns.length()) {
            if (ns.charAt(j) == ns.charAt(k)) {
                fail[j] = k + 1;
                ++j;
                ++k;
            } else if (k > 0) {
                k = fail[k - 1];
            } else {
                ++j;
            }
        }
        return new StringBuilder(s.substring(fail[ns.length() - 1])).reverse().toString() + s;
    }
}
