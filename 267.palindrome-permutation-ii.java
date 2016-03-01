/**
 * @see <a href="https://leetcode.com/problems/palindrome-permutation-ii/">Palindrome Permutation II</a>
 */

public class Solution {
    public List<String> generatePalindromes(String s) {
        if (s == null) throw new NullPointerException();
        List<String> res = new ArrayList<>();
        
        Map<Character, Integer> hm = getMap(s);
        int oddCount = 0;
        for (char c : hm.keySet()) {
            if (hm.get(c) % 2 != 0) ++oddCount;
            if (oddCount > 1) return res;
        }
        
        Set<String> set = generatePalindromesGivenMap(hm);
        res.addAll(set);
        return res;
    }
    
    private Map<Character, Integer> getMap(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        char c = ' ';
        for (int i = 0; i < s.length(); ++i) {
            c = s.charAt(i);
            hm.put(c, hm.containsKey(c) ? hm.get(c) + 1 : 1);
        }
        return hm;
    }
    
    private Set<String> generatePalindromesGivenMap(Map<Character, Integer> hm) {
        Set<String> res = new HashSet<>();
        if (hm.size() == 0) {
            res.add("");
        } else if (hm.size() == 1) { // only one element in the HashMap
            char someChar = 'a';
            for (char c : hm.keySet()) someChar = c; // to get the only key
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < hm.get(someChar); ++i) {
                sb.append(someChar);
            }
            res.add(new String(sb));
        } else {
            char someChar = 'a';
            for (char c : hm.keySet()) { // get a char that appear even number of times
                if (hm.get(c) % 2 == 0) {
                    someChar = c;
                    break;
                }
            }
            if (hm.get(someChar) == 2) hm.remove(someChar); // update the map.
            else hm.put(someChar, hm.get(someChar) - 2);

            Set<String> subRes = generatePalindromesGivenMap(hm); // recursive call
            for (String str : subRes) {
                for (int i = 0; i <= str.length() / 2; ++i) {
                    StringBuilder sb = new StringBuilder(str.substring(0, i));
                    sb.append(someChar);
                    sb.append(str.substring(i, str.length() - i));
                    sb.append(someChar);
                    sb.append(str.substring(str.length() - i));
                    res.add(new String(sb));
                }
            }
        }
        return res;        
    }
}
