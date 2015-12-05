/**
 * @see <a href="https://leetcode.com/problems/different-ways-to-add-parentheses/">Different Ways to Add Parentheses</a>
 */

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        
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
        
        res = diffWaysToCompute(nums, ops);
        return res;
    }
    
    public List<Integer> diffWaysToCompute(List<Integer> nums, List<Character> ops) {
        List<Integer> res = new ArrayList<>();
        if (ops.size() == 0) {
            res.add(nums.get(0));
        }
        else {
            int size = nums.size();
            for (int k = 1; k < size; ++k) {
                List<Integer> numsFirst = new ArrayList<>();
                List<Character> opsFirst = new ArrayList<>();
                List<Integer> numsSecond = new ArrayList<>();
                List<Character> opsSecond = new ArrayList<>();
                
                for (int i = 0; i < k; ++i) {
                    numsFirst.add(nums.get(i));
                }
                int i = 0;
                for (; i < k - 1; ++i) {
                    opsFirst.add(ops.get(i));
                }
                char op = ops.get(i);
                
                for (int j = k; j < size; ++j) {
                    numsSecond.add(nums.get(j));
                }
                ++i;
                for (; i < ops.size(); ++i) {
                    opsSecond.add(ops.get(i));
                }

                List<Integer> subRes1 = diffWaysToCompute(numsFirst, opsFirst);
                List<Integer> subRes2 = diffWaysToCompute(numsSecond, opsSecond);
                for (int num1 : subRes1) {
                    for (int num2 : subRes2) {
                        int newNum = calculate(num1, num2, op);
                        res.add(newNum);
                    }
                }
            }
        }
        return res;
    }
    // error: cannot find symbol: method calcuate(int,Integer,Character) ?????    
    public int calculate(int num1, int num2, char op) {
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
