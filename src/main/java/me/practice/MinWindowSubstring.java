package me.practice;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {

    public String minWindow2(String s, String t) {
        int[] map = new int[128];

        for (Character c : t.toCharArray()) {
            map[c]++;
        }

        int start = 0;
        int end = 0;
        int minStart = 0;
        int minLen = Integer.MAX_VALUE;
        int counter = t.length();

        while (end < s.length()) {
            char c1 = s.charAt(end);
            if (map[c1] > 0) counter--;
            map[c1]--;
            end++;
            while (counter == 0) {
                if (minLen > end - start) {
                    minLen = end - start;
                    minStart = start;
                }
                char c2 = s.charAt(start);
                map[c2]++;
                if (map[c2] > 0) counter++;
                start++;
            }
        }
        return minLen == Integer.MIN_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    public String minWindow(String s, String t) {
        if (t == null || t.length() == 0) return "";
        Map<Character, Integer> map = new HashMap<>();

        for (Character c : t.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }

        int start = 0;
        int subStr = 0;
        int matched = 0;
        int minLen = s.length() + 1;

        for (int endWindow = 0; endWindow < s.length(); endWindow++) {
            char right = s.charAt(endWindow);
            if (map.containsKey(right)) {
                map.put(right, map.get(right) - 1);
                if (map.get(right) == 0) matched++;
            }

            while (matched == map.size()) {
                if (minLen > (endWindow - start + 1)) {
                    minLen = (endWindow - start + 1);
                    subStr = start;
                }

                char deleted = s.charAt(start++);
                if (map.containsKey(deleted)) {
                    if (map.get(deleted) == 0) matched--;
                    map.put(deleted, map.get(deleted) + 1);
                }
            }
        }
        return minLen > s.length() ? "" : s.substring(subStr, subStr + minLen);
    }

    public static void main(String[] args) {
        MinWindowSubstring obj = new MinWindowSubstring();
        String res = obj.minWindow2("ADOBECODEBANC", "ABC");
        System.out.println(res);
    }

}
