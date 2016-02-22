/**
 * @see <a href="https://leetcode.com/problems/basic-calculator/">Basic Calculator</a>
 */

public class Solution {
    public int calculate(String s) {
        int i = 0;
        Stack<Character> operatorStk = new Stack<>();
        Stack<Integer> numStk = new Stack<>();
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) == ' ') ++i;
            if (i == s.length()) break;
            if (Character.isDigit(s.charAt(i))) {
                int start = i;
                ++i;
                while (i < s.length() && Character.isDigit(s.charAt(i))) ++i;
                int end = i;
                int num = Integer.parseInt(s.substring(start, end));
                if (numStk.isEmpty()) numStk.push(num);
                else {
                    if (operatorStk.peek() == '+' || operatorStk.peek() == '-') {
                        numStk.push(num);
                        calculate(operatorStk, numStk);
                    }
                    else { // operatorStk.peek() == '('
                        numStk.push(num);
                    }
                }
            }
            else {
                if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '(') {
                    operatorStk.push(s.charAt(i));
                }
                else {
                    while (operatorStk.peek() != '(') calculate(operatorStk, numStk);
                    operatorStk.pop();
                    while (!operatorStk.isEmpty() && (operatorStk.peek() == '+' || operatorStk.peek() == '-')) {
                        calculate(operatorStk, numStk);
                    }

                }
                ++i;
            }
        }
        while (operatorStk.size() != 0) calculate(operatorStk, numStk);
        return numStk.peek();
    }
    public void calculate(Stack<Character> operatorStk, Stack<Integer> numStk) {
        char c = operatorStk.pop();
        int num2 = numStk.pop();
        int num1 = numStk.pop();
        int res = 0;
        switch (c) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num1 - num2;
                break;
        }
        numStk.push(res);
    }
}
