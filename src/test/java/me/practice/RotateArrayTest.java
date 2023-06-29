package me.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class RotateArrayTest {

    @Test
    void testRotateThreePlace() {
        RotateArray obj = new RotateArray();
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 3;
        obj.rotate(nums, k);
        Assertions.assertArrayEquals(new int[] {4, 5, 6, 1, 2, 3}, nums);
    }

    @Test
    void testRotateOnePlace() {
        RotateArray obj = new RotateArray();
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 1;
        obj.rotate(nums, k);
        Assertions.assertArrayEquals(new int[] {6, 1, 2, 3, 4, 5}, nums);
    }

    @Test
    void testRotateSinglePlaceOneElement() {
        RotateArray obj = new RotateArray();
        int[] nums = {1};
        int k = 1;
        obj.rotate(nums, k);
        Assertions.assertArrayEquals(new int[] {1}, nums);
    }

    @Test
    void testRotateOptimize() {
        RotateArray obj = new RotateArray();
        int[] nums2 = new int[]{1, 2, 3, 4, 5, 6};
        int k = 3;
        obj.rotateOptimize(nums2, k);
        System.out.println(Arrays.toString(nums2));
        Assertions.assertArrayEquals(new int[] {4, 5, 6, 1, 2, 3}, nums2);
    }

    @Test
    void testRotateOptimizeOnePlace() {
        RotateArray obj = new RotateArray();
        int[] nums2 = new int[]{1, 2, 3, 4, 5, 6};
        int k = 1;
        obj.rotateOptimize(nums2, k);
        Assertions.assertArrayEquals(new int[] {6, 1, 2, 3, 4, 5}, nums2);
    }

    @Test
    void testRotateOptimizeOnePlaceForSingleArray() {
        RotateArray obj = new RotateArray();
        int[] nums2 = new int[]{1};
        int k = 1;
        obj.rotateOptimize(nums2, k);
        Assertions.assertArrayEquals(new int[] {1}, nums2);
    }
}