/**
 * @see <a href="https://leetcode.com/problems/basic-calculator-ii/">Basic Calculator II</a>
 */

public class Solution {
    public int calculate(String s) {
        Stack<Integer> stkNum = new Stack<>();
        Stack<Character> stkOp = new Stack<>();
        int i = 0; // integer can have more than one chars, so, use while instead of for
        while (i < s.length()) {
            if (s.charAt(i) != ' ') {
                if (Character.isDigit(s.charAt(i))) {
                    int start = i;
                    ++i;
                    while (i < s.length() && Character.isDigit(s.charAt(i))) ++i;
                    int num = Integer.parseInt(s.substring(start, i));
                    stkNum.push(num);
                } else {
                    if (stkOp.isEmpty()) {
                        stkOp.push(s.charAt(i));
                    } else {
                        while (!stkOp.isEmpty() && !higher(s.charAt(i), stkOp.peek())) {
                            calculate(stkNum, stkOp);
                        }
                        stkOp.push(s.charAt(i));
                    }
                    ++i;
                }
            } else {
                ++i;
            }
        }
        while (!stkOp.isEmpty()) calculate(stkNum, stkOp);
        return stkNum.pop();
    }
    private boolean higher(char high, char low) {
        // high and low will be operators.
        if (high == '+' || high == '-') {
            return false;
        } else {
            if (low == '*' || low == '/') return false;
            else return true;
        }
    }
    private void calculate(Stack<Integer> stkNum, Stack<Character> stkOp) {
        char op = stkOp.pop();
        int num2 = stkNum.pop();
        int num1 = stkNum.pop();
        int num = 0;
        switch (op) {
            case '+':
                num = num1 + num2;
                break;
            case '-':
                num = num1 - num2;
                break;
            case '*':
                num = num1 * num2;
                break;
            case '/':
                num = num1 / num2;
                break;
        }
        stkNum.push(num);
    }
}
