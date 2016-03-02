/**
 * @see <a href="https://leetcode.com/problems/anagrams/">Group Anagrams</a>
 */

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<List<Integer>, List<String>> hm = new HashMap<>();
        for (int i = 0; i < strs.length; ++i) {
            List<Integer> ak = getArray(strs[i]);
            if (hm.containsKey(ak)) {
                hm.get(ak).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                hm.put(ak, list);
            }
        }
        
        for (List<Integer> k : hm.keySet()) {
            // pay attention to the requirements.
            Collections.sort(hm.get(k));
            res.add(hm.get(k));
        }
        return res;
    }
    
    private List<Integer> getArray(String s) {
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < 26; ++i) array.add(0);
        for (int i = 0; i < s.length(); ++i) {
            array.set(s.charAt(i) - 'a', array.get(s.charAt(i) - 'a') + 1);
        }
        return array;
    }
}
