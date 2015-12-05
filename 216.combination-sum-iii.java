/**
 * @see <a href="https://leetcode.com/problems/combination-sum-iii/">Combination Sum III</a>
 */

public class Solution {
    public int sum;
    public Stack<Integer> stk;
    public int n;
    public int k;
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        stk = new Stack<Integer>(); // you must do this before you can use the stack!!!!!!!!!!!!!!!!!!!!!!!!!!!
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
            // organize the following code
            /*
            // all numbers less than or equal to 9, thus, if the second last number is 9, we backtrack.
            if (stk.peek() >= 9) backtrack();
            else if (sum + 9 < n) { // the maximum sum is less than n, we do not bactrack, we go forward one step!!!!!!!
                stk.push(stk.pop() + 1);
                sum += 1;
            }
            // if the minimum sum will be greater than n, we backtrack.
            else if (sum + stk.peek() + 1 > n) backtrack(); 
            else { // sum + 9 >= max, sum + stk.peek() + 1 <= n. we have some solution here:
                // this is the case where are are assured to find a combination.
                // thus, we find a solution, and then, go forward one step.
                List<Integer> list = getResultGivenStack(); 
                res.add(list);
                stk.push(stk.pop() + 1);
                sum = sum + 1;
            }
            if (stk.isEmpty()) break;
            */
            // organize the above code.
            int last = n - sum;
            if (last > 9) {
                stk.push(stk.pop() + 1);
                sum += 1;
            }
            // backtrack go to next availabe state if possible, and set stk to empty, if not possible.
            else if (last <= stk.peek()) backtrack(); 
            else {
                // we have a solution here; thus, we find the solution and go to next state.
                List<Integer> list = getResultGivenStack(); 
                res.add(list);
                stk.push(stk.pop() + 1);
                sum = sum + 1;                
            }
            if (stk.isEmpty()) break;            
        }
        return res;
    }
    
    public List<Integer> getResultGivenStack() {
        ArrayList<Integer> aList = new ArrayList<Integer>();
        while (!stk.isEmpty()) {
            aList.add(stk.pop());
        }
        Collections.reverse(aList);
        for (int i = 0; i < aList.size(); ++i) {
            stk.push(aList.get(i));
        }
        aList.add(n - sum);
        return aList;
    }
    
    public void backtrack() {
        int popCount = 0;
        int minN = 0;
        do {
            int top = stk.pop();
            ++popCount;
            sum = sum - top;
            if (stk.isEmpty()) return;
            
            stk.push(stk.pop() + 1);
            sum = sum + 1;
            minN = sum; 
            // if a variable is defined in the do loop, the conditions in while loop will not see it !!!!!!!!!!!
            // and will have compile error: cannot find symbol: variable minN
            for (int i = 0; i < k - stk.size(); ++i) {
                minN += stk.peek() + 1 + i;
            }
        } while (!stk.isEmpty() && (stk.peek() >= 9 || minN > n));
        
        // if (stk.isEmpty()) return;
        
        for (int i = 0; i < popCount; ++i) {
            sum += stk.peek() + 1;
            stk.push(stk.peek() + 1);
        }
    }
}
