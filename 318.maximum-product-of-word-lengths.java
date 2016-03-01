/**
 * https://leetcode.com/problems/maximum-product-of-word-lengths/
 */

public class Solution {
    public int maxProduct(String[] words) {
        if (words == null) throw new NullPointerException();
        if (words.length <= 1) return 0;
        int[] masks = new int[words.length];
        for (int i = 0; i < words.length; ++i) {
            for (int j = 0; j < words[i].length(); ++j) {
                masks[i] |= 1 << words[i].charAt(j) - 'a';
            }
        }
        
        int max = 0;
        for (int i = 0; i < words.length; ++i) {
            for (int j = i + 1; j < words.length; ++j) {
                // binary & operator has very low priority, need to use brace for them
                if ((masks[i] & masks[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
