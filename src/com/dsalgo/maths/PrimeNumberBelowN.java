package com.dsalgo.maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Sieve of Eratosthenes
//
public class PrimeNumberBelowN {
    public static void main(String[] args) {
        int n = 40;
        System.out.println(seive(n));
        System.out.println(primeNumbers(n));
        System.out.println(optimizedSeive(n));
    }

    /**
     * Bruteforce algo: Start a loop from 2 to n and check if each number is prime
     *
     * TC: O(n * log n)
     * SC: O(1)
     *
     * @param n
     * @return
     */
    private static List<Integer> primeNumbers(int n) {
        List<Integer> primes = new ArrayList<>();
        for(int i = 2; i <= n; i++) {
            if(isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    private static boolean isPrime(int n) {
        if(n < 1)
            return false;
        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Sieve of Erastosthenes: Create an array primes and initialise them as false
     * Run a loop from i = 2 to sqrt(n) because divisors appear in pairs.
     * If primes[i] is marked as false, run another loop from j from i * 2 to n
     * and mark primes[j] as true because the multiples of i are not primes.
     * Loop through primes arrays and indexes marked as false are prime numbers
     *
     * TC: O(n * log(log(n)))
     * SC: O(1)
     *
     */
    private static List<Integer> seive(int n) {
        boolean[] primes = new boolean[n + 1];
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

    /**
     * Optimized sieve of erastothenes: Instead of j = 2 * i, use i * i
     * @param n
     * @return
     */
    private static List<Integer> optimizedSeive(int n) {
        boolean[] primes = new boolean[n + 1];
        List<Integer> primeNumbers = new ArrayList<>();
        for(int i = 2; i * i <= n; i++){
            if(!primes[i]) {
                for(int j = i * i; j <= n; j = j + i) {
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
