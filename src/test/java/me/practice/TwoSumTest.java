package me.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    @Test
    void testTwoSum() {
        int[] input = {2, 1, 4, 5, 3, 8};
        TwoSum twoSumObj = new TwoSum();
        int[] ans = twoSumObj.twoSumTarget(input, 12);
        Assertions.assertArrayEquals(new int[] {4, 8}, ans);
    }

    @Test
    void testTwoSum_whenNoPair_ReturnNull() {
        int[] input = {2, 1, 4, 5, 3, 8};
        TwoSum twoSumObj = new TwoSum();
        int[] ans = twoSumObj.twoSumTarget(input, 1);
        Assertions.assertNull(ans);
    }
}