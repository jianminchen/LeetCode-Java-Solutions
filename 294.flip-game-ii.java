/**
 * @see <a href="https://leetcode.com/problems/flip-game-ii/">Flip Game II</a>
 */

public class Solution {
    public boolean canWin(String s) {
        // generate all possible strings after a move. 
        // This seems to have repeated calculations. TODO: try to use memorization technique to reduce time complexity
        List<String> list = generateAll(s); 
        if (list.isEmpty()) return false;
        for(String aStr : list) {
            if (!canWin(aStr)) return true; // if the other one is to lose, we can win
        }
        return false;
    }
    private List<String> generateAll(String s) {
        List<String> list = new ArrayList<String>();
        int i = 0;
        while (i < s.length()) {
            int startMinus = i;
            while (i < s.length() && s.charAt(i) == '-') ++i;
            int endMinus = i;
            if (i >= s.length()) break;
            
            int startPlus = i;
            while (i < s.length() && s.charAt(i) == '+') ++i;
            int endPlus = i;
            if (startPlus == endPlus - 1) {}
            else { // give startPlus, and endPlus, generate all possible strings after one move.
                List<String> subList = generateGivenStartAndEnd(s, startPlus, endPlus);
                list.addAll(subList);
            }
        }
        return list;
    }
    private List<String> generateGivenStartAndEnd(String s, int startPlus, int endPlus) {
        List<String> list = new ArrayList<String>();  // endPlus is exclusive.
        for (int i = startPlus; i <= endPlus - 2; ++i) {
            String newS = s.substring(0, i) + "--" + s.substring(i + 2);
            list.add(newS);
        }
        return list;
    }
}
