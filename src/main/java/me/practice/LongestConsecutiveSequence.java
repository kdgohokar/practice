package me.practice;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutiveSequenceLength(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (Integer n : nums) set.add(n);
        int longest = 0;
        for (Integer n : nums) {
            if (!set.contains(n-1)) {
                int length = 1;
                while (set.contains(n+length))
                    length++;
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}
