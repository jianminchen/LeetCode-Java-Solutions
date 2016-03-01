/**
 * @see <a href="https://leetcode.com/problems/combination-sum-iii/">Combination Sum III</a>
 */

public class Solution {
    // explicit iterative backtracking solution using stack.
    private Stack<Integer> stk;
    private int sum, n, k;
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        stk = new Stack<Integer>();
        this.n = n;
        this.k = k;
        if (k > 9) return res;
        sum = 0;
        for (int i = 1; i < k; ++i) {
            stk.push(i);
            sum += i;
        }
        // we use a stack that has k - 1 values, to represent a solution, the last number will be n - sum
        while (true) {
            int last = n - sum;
            if (last > 9) {
                stk.push(stk.pop() + 1);
                ++sum;
            } else if (last <= stk.peek()) {
                backtrack(); // backtrack, and go to next availabe state if possible; set stk to empty if not possible.
            } else { // we have a solution here; thus, we find the solution and go to next state.
                List<Integer> aRes = new ArrayList<>(stk);
                aRes.add(n - sum);
                res.add(aRes);
                stk.push(stk.pop() + 1);
                ++sum;
            }
            if (stk.isEmpty()) break;            
        }
        return res;
    }
    
    private void backtrack() {
        int popCount = 0, minN = 0;
        do {
            int top = stk.pop();
            ++popCount;
            sum = sum - top;
            if (stk.isEmpty()) return; // cannot backtrack
            
            stk.push(stk.pop() + 1);
            ++sum;
            minN = sum;
            for (int i = 0; i < k - stk.size(); ++i) {
                minN += stk.peek() + 1 + i;
            }
        } while (!stk.isEmpty() && (stk.peek() >= 9 || minN > n));
        
        for (int i = 0; i < popCount; ++i) {
            sum += stk.peek() + 1;
            stk.push(stk.peek() + 1);
        }
    }
}
