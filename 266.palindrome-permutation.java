/**
 * @see <a href="https://leetcode.com/problems/palindrome-permutation/">Palindrome Permutation</a>
 */

public class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null) return true;
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            hm.put(s.charAt(i), hm.containsKey(s.charAt(i)) ? hm.get(s.charAt(i)) + 1 : 1);
        }
        int oddCount = 0;
        for(Character c : hm.keySet()) {
            if (hm.get(c) % 2 != 0) {
                ++oddCount;
                if (oddCount > 1) return false;
            }
        }
        return true;
    }
}
