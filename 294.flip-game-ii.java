/**
 * @see <a href="https://leetcode.com/problems/flip-game-ii/">Flip Game II</a>
 */

public class Solution {
    public boolean canWin(String s) {
        List<String> list = generateAll(s);
        if (list.isEmpty()) return false;
        boolean canW = false;
        for(String aStr : list) {
            canW = canW || !canWin(aStr);
        }
        return canW;
    }
    public List<String> generateAll(String s) {
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
            if (startPlus == endPlus - 1) ;// no possible move
            else {
                // give startPlus, and endPlus, generate all possible strings after one move.
                List<String> subList = generateGivenStartAndEnd(s, startPlus, endPlus);
                list.addAll(subList);
            }
        }
        return list;
    }
    public List<String> generateGivenStartAndEnd(String s, int startPlus, int endPlus) {
        // endPlus is exclusive.
        List<String> list = new ArrayList<String>();
        for (int i = startPlus; i <= endPlus - 2; ++i) {
            String newS = s.substring(0, i) + "--" + s.substring(i + 2);
            list.add(newS);
        }
        return list;
    }
}
