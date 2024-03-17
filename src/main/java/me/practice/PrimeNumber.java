package me.practice;

public class PrimeNumber {

    public static void main(String[] args) {
        // Find the prime numbers between 1 and 100.

        for (int i = 1; i <= 100; i++) {
            if (isPrime(i)) {
                System.out.println(i + " is a prime number");
            } else {
                System.out.println(i + " is not a prime number");
            }
        }
    }

    private static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


}
