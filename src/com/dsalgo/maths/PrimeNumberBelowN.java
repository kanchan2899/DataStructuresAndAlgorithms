package com.dsalgo.maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Sieve of Eratosthenes
//
public class PrimeNumberBelowN {
    public static void main(String[] args) {
        int n = 40;
        boolean[] primes = new boolean[n + 1];
        System.out.println(String.valueOf(seive(n, primes)));
    }

    // False in primes array means the number is prime. Otherwise, it is not prime.
    private static List<Integer> seive(int n, boolean[] primes) {
        List<Integer> primeNumbers = new ArrayList<>();
        for(int i = 2; i * i <= n; i++){
            if(!primes[i]) {
                for(int j = i * 2; j <= n; j = j + i) {
                    primes[j] = true;
                }
            }
        }
        for(int i = 2; i <= n; i++) {
            if(!primes[i]) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }
}
