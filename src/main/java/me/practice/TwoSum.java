package me.practice;

import java.util.HashSet;
import java.util.Set;

public class TwoSum {

    public int[] twoSumTarget(int[] inputArray, int target) {
        Set<Integer> complement = new HashSet<>();
        for (int j : inputArray) {
            int comp = target - j;
            if (complement.contains(comp)) {
                return new int[]{comp, j};
            } else {
                complement.add(j);
            }
        }
        return null;
    }
}
