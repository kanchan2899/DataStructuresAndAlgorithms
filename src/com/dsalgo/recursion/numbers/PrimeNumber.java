package com.dsalgo.recursion.numbers;

// Recursive Prime Number
public class PrimeNumber {
    public static void main(String[] args) {
        int[] n = {2, 5, 15, 21, 91, 97, 100};
        for(int s : n)
            System.out.println(isPrime(s, 2));
    }

    private static boolean isPrime(int n, int divisor) {
        if(n <= 2)
            return true;
        if(n % divisor == 0)
            return false;
        if(divisor * divisor >= n)
            return true;
        return isPrime(n, divisor + 1);
    }
}
