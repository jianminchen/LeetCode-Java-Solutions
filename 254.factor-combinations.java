/**
 * @see <a href="https://leetcode.com/problems/factor-combinations/">Factor Combinations</a>
 */

public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        
        List<Integer> cands = new ArrayList<>();
        for (int i = 2; i <= n / 2; ++i) {
            if (n % i == 0) cands.add(i);
        }
        Set<List<Integer>> set = getFactors(n, cands, 0);
        for (List<Integer> li : set) {
            res.add(li);
        }
        return res;
    }
    public Set<List<Integer>> getFactors(int n, List<Integer> cands, int start) {
        Set<List<Integer>> set = new HashSet<>();
        if (start >= cands.size()) return set;
        // if (cands.get(start) > n / cands.get(start)) return set;
        if (cands.get(start) > n) return set;
        // including start; may include several times.
        int count = 1;
        int factor = cands.get(start);
        while (n % factor == 0) {
            // only consists of cands.get(start);
            if (factor == n) {
                List<Integer> newRes = new ArrayList<>();
                for (int i = 0; i < count; ++i) {
                    newRes.add(cands.get(start));
                }
                set.add(newRes);
                break;
            }
            // include start count times.
            for (List<Integer> aRes : getFactors(n / factor, cands, start + 1)) {
                List<Integer> newRes = new ArrayList<>();
                for (int i = 0; i < count; ++i) {
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
            List<Integer> newRes = new ArrayList<>();
            newRes.addAll(aRes);
            set.add(newRes);
        }
        return set;
    }
}
