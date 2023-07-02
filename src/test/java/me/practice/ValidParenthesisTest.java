package me.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesisTest {

    @Test
    void testValidParenthesis() {
        ValidParenthesis obj = new ValidParenthesis();
        Assertions.assertTrue(obj.isValid("(){}[]"));
        Assertions.assertTrue(obj.isValid("()"));
        Assertions.assertTrue(obj.isValid("([{}])"));
        Assertions.assertFalse(obj.isValid("]"));
        Assertions.assertFalse(obj.isValid("(]"));
    }
}