package me.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestConsecutiveSequenceTest {

    @Test
    void testLongestConsecutiveSequenceLength() {
        LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
        Assertions.assertEquals(4, obj.longestConsecutiveSequenceLength(new int[]{100, 4, 200, 2, 3, 1}));
        Assertions.assertEquals(9, obj.longestConsecutiveSequenceLength(new int[]{0,3,7,2,5,8,4,6,0,1}));
        Assertions.assertEquals(1, obj.longestConsecutiveSequenceLength(new int[]{30, 20, 10, 13}));
    }
}