/**
 * @see <a href="https://leetcode.com/problems/factor-combinations/">Factor Combinations</a>
 */

public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<Integer> cands = new ArrayList<>();
        for (int i = 2; i <= n / 2; ++i) {
            if (n % i == 0) cands.add(i); // all possible factors
        }
        return new ArrayList<List<Integer>>(getFactors(n, cands, 0));
    }
    public Set<List<Integer>> getFactors(int n, List<Integer> cands, int start) {
        Set<List<Integer>> set = new HashSet<>();
        if (start >= cands.size()) return set;
        if (cands.get(start) > n) return set;
        int count = 1;
        int factor = cands.get(start);
        while (n % factor == 0) {
            if (factor == n) { // only consists of cands.get(start);
                List<Integer> newRes = new ArrayList<>();
                for (int i = 0; i < count; ++i) {
                    newRes.add(cands.get(start));
                }
                set.add(newRes);
                break;
            }
            for (List<Integer> aRes : getFactors(n / factor, cands, start + 1)) {
                List<Integer> newRes = new ArrayList<>();
                for (int i = 0; i < count; ++i) { // include start count times.
                    newRes.add(cands.get(start));
                }
                newRes.addAll(aRes);
                set.add(newRes);
            }
            factor = factor * cands.get(start);
            ++count;
        }

        // does not include start;
        for (List<Integer> aRes : getFactors(n, cands, start + 1)) {
            List<Integer> newRes = new ArrayList<>(aRes);
            set.add(newRes);
        }
        return set;
    }
}
