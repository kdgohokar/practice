package me.practice;

import java.util.Stack;

public class ValidParenthesis {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch == '(')
                stack.push(')');
            else if (ch == '{')
                stack.push('}');
            else if (ch == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != ch)
                return false;
            i++;
        }
        return true;
    }

}
