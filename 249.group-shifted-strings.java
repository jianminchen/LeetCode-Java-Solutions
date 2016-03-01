/**
 * @see <a href="https://leetcode.com/problems/group-shifted-strings/">Group Shifted Strings</a>
 */

public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        // use hashMap, key is the pattern that starts with character a.
        // the values will be an arrayList of words that have the same pattern.
        List<List<String>> lls = new ArrayList<>();
        Map<String, ArrayList<String>> hm = new HashMap<>();
        for (int i = 0; i < strings.length; i ++) {
            String pattern = shiftingBack(strings[i]);
            if (hm.containsKey(pattern)) {
                hm.get(pattern).add(strings[i]);
            } else {
                ArrayList<String> aList = new ArrayList<String>();
                aList.add(strings[i]);
                hm.put(pattern, aList);
            }
        }
        
        for (String s : hm.keySet()) {
            Collections.sort(hm.get(s));
            lls.add(hm.get(s));
        }
        return lls;
    }
    
    private String shiftingBack(String s) {
        // a string that may or may not starts with a, shift back to a pattern.
        int diff = s.charAt(0) - 'a';
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) - 'a' >= diff) {
                char c = (char) (s.charAt(i) - diff);
                sb.append(c);
            } else {
                char c = (char) (s.charAt(i) - diff + 26);
                sb.append(c);
            }
        }
        return new String(sb);
    }
}
