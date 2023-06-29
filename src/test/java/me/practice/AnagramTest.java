package me.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AnagramTest {

    @Test
    void testIsAnagram() {
        Anagram anagram = new Anagram();
        Assertions.assertFalse(anagram.isAnagram("anagram", "cat"));
        Assertions.assertFalse(anagram.isAnagram("rat", "cat"));
        Assertions.assertTrue(anagram.isAnagram("", ""));
        Assertions.assertTrue(anagram.isAnagram("nagaram", "anagram"));
    }
}