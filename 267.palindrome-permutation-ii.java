/**
 * @see <a href="https://leetcode.com/problems/palindrome-permutation-ii/">Palindrome Permutation II</a>
 */

public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) return res;
        
        Map<Character, Integer> hm = getMap(s);
        int oddCount = 0;
        for (char c : hm.keySet()) {
            if (hm.get(c) % 2 != 0) ++oddCount;
            if (oddCount > 1) return res;
        }
        
        Set<String> set = generatePalindromesGivenMap(hm);
        for (String str : set) {
            res.add(str);
        }
        return res;
    }
    
    public Map<Character, Integer> getMap(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            if (hm.containsKey(s.charAt(i))) hm.put(s.charAt(i), hm.get(s.charAt(i)) + 1);
            else hm.put(s.charAt(i), 1);
        }
        return hm;
    }
    
    public Set<String> generatePalindromesGivenMap(Map<Character, Integer> hm) {
        Set<String> res = new HashSet<>();
        if (hm.size() == 0) {
            String s = "";
            res.add(s);
        }
        else if (hm.size() == 1) {
            char someChar = 'a';
            for (char c : hm.keySet()) someChar = c;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < hm.get(someChar); ++i) {
                sb.append(someChar);
            }
            res.add(new String(sb));
        }
        else {
            char someChar = 'a';
            for (char c : hm.keySet()) {
                if (hm.get(c) % 2 == 0) {
                    someChar = c;
                    break;
                }
            }
            // choose a char that appears even number of times.
            // update the map.
            if (hm.get(someChar) == 2) hm.remove(someChar);
            else hm.put(someChar, hm.get(someChar) - 2);

            Set<String> subRes = generatePalindromesGivenMap(hm);
            for (String str : subRes) {
                for (int i = 0; i <= str.length() / 2; ++i) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str.substring(0, i));
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
