/**
 * @see <a href="https://leetcode.com/problems/palindrome-partitioning/">Palindrome Partitioning</a>
 */

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<List<String>>> results = new ArrayList<>();
        // results.get(i) will be the partitions for s.substring(0, i);

        List<List<String>> first = new ArrayList<>();
        List<String> firstP = new ArrayList<>();
        first.add(firstP);
        results.add(first);
            
        for (int i = 1; i <= s.length(); ++i) {
            List<List<String>> cur = new ArrayList<>();
            // the last word which is palindrome, plus previous
            // the length of last word can be i.
            for (int j = i - 1; j >= 0; --j) {
                if (isPalindrome(s.substring(j, i))) {
                    System.out.println("j : " + j + " i : " + i);                    	
                    for (List<String> prev : results.get(j)) {
                        List<String> curP = new ArrayList<>();
                        curP.addAll(prev);
                        curP.add(s.substring(j, i));
                        cur.add(curP);
                    }
                }
            }
            results.add(cur);
        }
        return results.get(s.length());
    }
    
    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; ++i) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }
}
