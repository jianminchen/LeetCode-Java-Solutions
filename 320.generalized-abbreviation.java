public class Solution {
    public List<String> generateAbbreviations(String word) {
        if (word == null) throw new NullPointerException();
        Set<String> res = new HashSet<>();
        Map<String, Set<String>> abbMap = new HashMap<>();
        res = helper(word, abbMap);
        return new ArrayList<String>(res);
    }
    private Set<String> helper(String word, Map<String, Set<String>> abbMap) {
        Set<String> res = new HashSet<>();
        if (word.length() == 0) {
            res.add("");
            abbMap.put("", res);
            return res;
        }
        // no abbreviation
        res.add(word);
        // use number k to abbreviate k characters, k from si to ei - si + 1.
        for (int k = 1; k <= word.length(); ++k) {
            for (int i = 0; i <= word.length() - k; ++i) {
                // from i, to i + k - 1, inclusive, is represented by k
                String before = i - 1 >= 0 ? word.substring(0, i - 1) : "";
                String after = i + k + 1<= word.length() ? word.substring(i + k + 1) : "";
                Set<String> beforeSet = abbMap.containsKey(before) ? abbMap.get(before) : helper(before, abbMap);
                Set<String> afterSet = abbMap.containsKey(after) ? abbMap.get(after) : helper(after, abbMap);
                for (String s1 : beforeSet) {
                    for (String s2 : afterSet) {
                        String str = s1;
                        if (i - 1 >= 0) str = str + word.charAt(i - 1);
                        str += Integer.toString(k);
                        if (i + k <= word.length() - 1) str += word.charAt(i + k);
                        str += s2;
                        res.add(str);
                        
                    }
                }
            }
        }
        abbMap.put(word, res);
        return res;
    }
}
