package me.practice;

import java.util.*;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) return false;

        int[] freq1 = new int[26];
        for (int i = 0; i < len1; i++) {
            freq1[s1.charAt(i) - 'a']++;
        }

        int[] freq2 = new int[26];
        for (int i = 0; i < len2; i++) {
            freq2[s2.charAt(i) - 'a']++;
            if (i >= len1) {
                char ch = s2.charAt(i - len1);
                freq2[ch - 'a']--;
            }
            if (Arrays.equals(freq1, freq2))
                return true;
        }
        return false;
    }

    public boolean checkInclusion2(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) return false;
        Map<Character, Integer> countMap = new HashMap<>(26);
        for (int i = 0; i < len1; i++) {
            countMap.merge(s1.charAt(i), 1, Integer::sum);
        }
        for (int i = 0; i < len2; i++) {
            char c = s2.charAt(i);
            countMap.put(c, countMap.getOrDefault(c, 0) - 1);
            if (i >= len1) {
                char ch = s2.charAt(i - len1);
                countMap.put(ch, countMap.getOrDefault(ch, 1) + 1);
            }
            if (allZeros(countMap.values())) {
                return true;
            }
        }
        return false;
    }

    private static boolean allZeros(Collection<Integer> values) {
        return values.stream().allMatch(a -> a == 0);
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidceoba";
        PermutationInString pm = new PermutationInString();
        boolean checked = pm.checkInclusion2(s1, s2);
        System.out.println(checked);
    }
}
