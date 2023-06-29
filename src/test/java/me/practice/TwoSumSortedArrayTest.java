package me.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumSortedArrayTest {

    @Test
    void testTwoSum() {
        TwoSumSortedArray obj = new TwoSumSortedArray();
        Assertions.assertArrayEquals(new int[] {1, 2}, obj.twoSum(new int[] {2,7,11,15}, 9));
        Assertions.assertArrayEquals(new int[] {1, 3}, obj.twoSum(new int[] {2,3,4}, 6));
        Assertions.assertArrayEquals(new int[] {1, 2}, obj.twoSum(new int[] {-1,0}, -1));
    }
}