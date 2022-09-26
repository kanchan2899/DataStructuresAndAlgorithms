package com.dsalgo.maths;

// https://leetcode.com/problems/count-primes/
public class CountPrimes {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(countPrimes(n));
    }
    public static int countPrimes(int n) {
        int count = 0;
        boolean[] primes = new boolean[n];
        for(int i = 2; i < n; i++) {
            if(!primes[i]) {
                for(int j = i * 2; j < n; j += i) {
                    primes[j] = true;
                }
            } else {
                count++;
            }
        }
//        for(int i = 2; i < n; i++) {
//            if(!primes[i]) {
//                count++;
//            }
//        }
        return count;
    }
}
