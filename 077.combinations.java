/**
 * @see <a href="https://leetcode.com/problems/combinations/">Combinations</a>
 */

public class Solution {
    // iterative backtrack solution
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Stack<Integer> stk = new Stack<Integer>();

        for (int i = 1; i <= k; ++i) {
            stk.push(i);
        }
        if (stk.peek() > n) {
            return lists;
        }
        while (true) {
            if (stk.peek() > n) { // not valid: backtrack:
                backtrack(stk, n, k);
            } else { // valid: go forward (the next may or may not be valid)
                // get a result
                List<Integer> al = generateResultGivenStack(stk);
                lists.add(al);
                // go to next.
                stk.push(stk.pop() + 1);
            }
            if (stk.isEmpty()) break;
        }
        return lists;
    }
    
    private List<Integer> generateResultGivenStack(Stack<Integer> stk) {
        List<Integer> list = new ArrayList<Integer>();
        while (!stk.isEmpty()) {
            list.add(stk.pop());
        }
        for (int i = list.size() - 1; i >= 0; --i){
            stk.push(list.get(i));
        }
        Collections.reverse(list);
        return list;
    }
    
    private void backtrack(Stack<Integer> stk, int n, int k) {
        int popCount = 0;
        while (!stk.isEmpty() && stk.peek() + (k - stk.size()) >= n) {
            stk.pop();
            ++popCount;
        }
        if (stk.isEmpty()) return;
        stk.push(stk.pop() + 1);
        for (int i = 0; i < popCount; ++i) {
            stk.push(stk.peek() + 1);
        }
    }
}
