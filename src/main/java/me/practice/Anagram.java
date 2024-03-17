package me.practice;

public class Anagram {

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null)
            return false;
        if (s.length() != t.length())
            return false;
        int[] alphabets = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabets[s.charAt(i) - 'a']++;
        }
        for (int j = 0; j < t.length(); j++) {
            alphabets[t.charAt(j) - 'a']--;
        }
        for (int alphabet : alphabets) {
            if (alphabet != 0) {
                return false;
            }
        }
        return true;
    }
}
