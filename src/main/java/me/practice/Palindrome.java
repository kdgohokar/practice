package me.practice;

public class Palindrome {


    public boolean isPalindrome(String s) {
        if (s == null || s.isBlank()) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            Character leftCh = s.charAt(left);
            Character rightCh = s.charAt(right);

            if (!Character.isLetterOrDigit(leftCh)) {
                left++;
            } else if (!Character.isLetterOrDigit(rightCh)) {
                right--;
            } else {
                if (Character.toLowerCase(leftCh) != Character.toLowerCase(rightCh)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}