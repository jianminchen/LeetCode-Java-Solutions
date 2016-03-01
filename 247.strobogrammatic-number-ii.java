/**
 * @see <a href="https://leetcode.com/problems/strobogrammatic-number-ii/">Strobogrammatic Number II</a>
 */
// dynamic programming solution, constructing the ith list from previous lists
public class Solution {
    public List<String> findStrobogrammatic(int n) {
        String[][] chart = new String[][]{{"1", "1"}, {"8", "8"}, {"6", "9"}, {"9", "6"}};
        if (n == 0) return new ArrayList<String>();
        List<List<String>> lists = new ArrayList<>();
        // initialize
        List<String> list1 = new ArrayList<>();
        list1.add("0"); list1.add("1"); list1.add("8");
        lists.add(list1); // get(0)
        List<String> list2 = new ArrayList<>();
        list2.add("11"); list2.add("88"); list2.add("69"); list2.add("96");
        lists.add(list2); // get(1)
        for (int i = 3; i <= n; ++i) {
            int count = (i - 1) / 2, start = 1;
            if (i % 2 == 0) start = 2; // start from 1, or 2.
            int zeros = count - 1;
            List<String> listi = new ArrayList<>();
            for (int j = 0; j < count; ++j, start += 2, --zeros) {
                for (String s : lists.get(start - 1)) {
                    for (int ci = 0; ci < chart.length; ++ci) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(chart[ci][0]);
                        for (int k = 0; k < zeros; ++k) {
                            sb.append(0);
                        }
                        sb.append(s);
                        for (int k = 0; k < zeros; ++k) {
                            sb.append(0);
                        }
                        sb.append(chart[ci][1]);
                        String newS = new String(sb);
                        listi.add(newS);
                    }
                }
            }
            // for even number, we need to consider the case where middle digits are all zeros.
            if (i % 2 == 0) {
                for (int ci = 0; ci < chart.length; ++ci) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(chart[ci][0]);
                    for (int k = 0; k < i - 2; ++k) {
                        sb.append(0);
                    }
                    sb.append(chart[ci][1]);
                    String newS = new String(sb);
                    listi.add(newS);
                }
            }
            lists.add(listi);
        }
        return lists.get(n - 1);
    }
}
