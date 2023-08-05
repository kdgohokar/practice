package me.practice;

public class ReverseNumber {

    public static int reverseNumber(int n) {
        int res = 0;
        while (n > 0) {
            int digit = n % 10;
            res *= 10;
            res += digit;
            n = n / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int res = reverseNumber(54321);
        System.out.println(res);
    }
}
