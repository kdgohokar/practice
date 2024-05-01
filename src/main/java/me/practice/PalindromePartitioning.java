package me.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(String s, List<String> tempList, List<List<String>> res) {
        if (s == null || s.length() == 0) {
            res.add(new ArrayList<>(tempList));
        } else {
            for (int i = 1; i <= s.length(); i++) {
                String temp = s.substring(0, i);
                if (isPalindrome(temp)) {
                    tempList.add(temp);
                    backtrack(s.substring(i), tempList, res);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s) {
        int low = 0;
        int high = s.length() - 1;
        while (low <= high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning p = new PalindromePartitioning();
        List<List<String>> res = p.partition("aab");
        System.out.println(res);
    }
}