package me.practice;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ReversePolishNotation {

    private static final Set<String> OPERATORS = Set.of("+", "-", "*", "/");

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                Integer op1 = stack.pop();
                Integer op2 = stack.pop();
                stack.push(op1 + op2);
            } else if ("-".equals(token)) {
                Integer op1 = stack.pop();
                Integer op2 = stack.pop();
                stack.push(op1 - op2);
            } else if ("*".equals(token)) {
                Integer op1 = stack.pop();
                Integer op2 = stack.pop();
                stack.push(op1 * op2);
            } else if ("/".equals(token)) {
                Integer op1 = stack.pop();
                Integer op2 = stack.pop();
                stack.push(op2 / op1);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] input = {"4","13","5","/","+"};
        ReversePolishNotation obj = new ReversePolishNotation();
        int rpn = obj.evalRPN(input);
        System.out.println(rpn);
    }
}
