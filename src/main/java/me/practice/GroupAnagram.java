package me.practice;

import java.util.*;

public class GroupAnagram {

    public List<List<String>> groupAnagram(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] bucket = new char[26];
            for (char c : s.toCharArray()) {
                bucket[c - 'a']++;
            }
            String key = String.valueOf(bucket);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        GroupAnagram obj = new GroupAnagram();
        List<List<String>> groupAnagram = obj.groupAnagram(strs);
        System.out.println(groupAnagram);
    }
}