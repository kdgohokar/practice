package me.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PalindromeTest {

    @Test
    void testIsPalindrome() {
        Palindrome palindrome = new Palindrome();
        Assertions.assertTrue(palindrome.isPalindrome(""));
        Assertions.assertTrue(palindrome.isPalindrome(null));
        Assertions.assertTrue(palindrome.isPalindrome("D"));
        Assertions.assertTrue(palindrome.isPalindrome("Naman"));
        Assertions.assertTrue(palindrome.isPalindrome("A man, a plan, a canal: Panama"));
    }
}