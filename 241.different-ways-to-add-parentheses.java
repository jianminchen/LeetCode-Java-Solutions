/**
 * @see <a href="https://leetcode.com/problems/different-ways-to-add-parentheses/">Different Ways to Add Parentheses</a>
 */
 
// divide and conquer approach
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        if (input == null) throw new NullPointerException();
        List<Integer> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        int i = 0;
        while (i < input.length()) {
            int start = i;
            while (i < input.length() && Character.isDigit(input.charAt(i))) ++i;
            nums.add(Integer.parseInt(input.substring(start, i)));
            if (i == input.length()) break;
            char op = input.charAt(i);
            ops.add(op);
            ++i;
        }
        return diffWaysToCompute(nums, ops);
    }
    
    private List<Integer> diffWaysToCompute(List<Integer> nums, List<Character> ops) {
        List<Integer> res = new ArrayList<>();
        if (ops.size() == 0) { // no operators, thus, return the pure number
            res.add(nums.get(0));
            return res;
        }
        
        int size = nums.size();
        for (int k = 1; k < size; ++k) { // partition the nums, and ops at location k
            List<Integer> numsFirst = new ArrayList<>(), numsSecond = new ArrayList<>();
            List<Character> opsFirst = new ArrayList<>(), opsSecond = new ArrayList<>();
            // the first half
            for (int i = 0; i < k; ++i) {
                numsFirst.add(nums.get(i));
            }
            int i = 0;
            for (; i < k - 1; ++i) {
                opsFirst.add(ops.get(i));
            }
            char op = ops.get(i);
            // the second half
            for (int j = k; j < size; ++j) {
                numsSecond.add(nums.get(j));
            }
            ++i;
            for (; i < ops.size(); ++i) {
                opsSecond.add(ops.get(i));
            }
            // calcualte the first half and the second half, then combine them
            List<Integer> subRes1 = diffWaysToCompute(numsFirst, opsFirst);
            List<Integer> subRes2 = diffWaysToCompute(numsSecond, opsSecond);
            for (int num1 : subRes1) {
                for (int num2 : subRes2) {
                    int newNum = calculate(num1, num2, op);
                    res.add(newNum);
                }
            }
        }
        return res;
    }
    
    private int calculate(int num1, int num2, char op) {
        int num = 0;
        switch(op) {
            case '-':
                num = num1 - num2;
                break;
            case '+':
                num = num1 + num2;
                break;
            case '*':
                num = num1 * num2;
                break;
        }
        return num;
    }
}
