package me.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParenthesis {

    private static final Stack<Character> STACK = new Stack<>();
    private static final List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n);
        return result;
    }

    private void backtrack(int openCount, int closeCount, int n) {
        if (openCount == closeCount && closeCount == n) {
            StringBuilder temp = new StringBuilder();
            for (Character ch : STACK) {
                temp.append(ch);
            }
            result.add(temp.toString());
        }

        if (openCount < n) {
            STACK.push('(');
            backtrack(openCount + 1, closeCount, n);
            STACK.pop();
        }

        if (closeCount < openCount) {
            STACK.push(')');
            backtrack(openCount, closeCount + 1, n);
            STACK.pop();
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis obj = new GenerateParenthesis();
        List<String> strings = obj.generateParenthesis(2);
        System.out.println(strings);
    }
}
