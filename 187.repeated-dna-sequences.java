/**
 * @see <a href="https://leetcode.com/problems/repeated-dna-sequences/">Repeated DNA Sequences</a>
 */

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() <= 10) return res;
        Map<Integer, Boolean> hm = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; ++i) {
            String sub = s.substring(i, i + 10);
            int num = toNumber(sub);
            if (hm.containsKey(num)) {
                if (hm.get(num) == false) {
                    res.add(sub);
                    hm.put(num, true);
                }
            } else {
                hm.put(num, false); // appear before but not added to res yet.
            }
        }
        return res;
    }
    
    private int toNumber(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            int n = 0;
            switch (c) {
                case 'A':
                    n = 0;
                    break;
                case 'C':
                    n = 1;
                    break;
                case 'G':
                    n = 2;
                    break;
                case 'T':
                    n = 3;
                    break;
            }
            sb.append(n);
        }
        String str = new String(sb);
        return Integer.parseInt(str, 4);
    }
}
