/**
 * @see <a href="https://leetcode.com/problems/combinations/">Combinations</a>
 */

public class Solution {
    // public Stack<Integer> stk;
    public int n;
    public int k;
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
            // not valid: backtrack:
            if (stk.peek() > n) backtrack(stk, n, k);
            else {
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
    public List<Integer> generateResultGivenStack(Stack<Integer> stk) {
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
    public void backtrack(Stack<Integer> stk, int n, int k) {
        // the input is a result where the top of the stack is >  n.
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
