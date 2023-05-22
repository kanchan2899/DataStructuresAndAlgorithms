package com.dsalgo.maths;

import java.util.ArrayList;
import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/prime-factors5052/1
public class PrimeFactors {
    public static void main(String[] args) {
        int n = 1096;
        System.out.println(Arrays.toString(allPrimeFactors(n)));
        System.out.println(Arrays.toString(allPrimeFactors1(n)));
    }

    private static int[] allPrimeFactors1(int n) {
        ArrayList<Integer> primeFactors = new ArrayList<>();
        if(n <= 1) {
            return new int[]{};
        }

        while (n % 2 == 0) {
            primeFactors.add(2);
            n /= 2;
        }

        while (n % 3 == 0) {
            primeFactors.add(3);
            n /= 3;
        }

        for(int i = 5; i * i <= n; i = i + 6) {
            while (n % i == 0) {
                primeFactors.add(i);
                n /= i;
            }

            while (n % (i + 2) == 0) {
                primeFactors.add(i + 2);
                n /= (i + 2);
            }
        }

        if(n >= 2) {
            primeFactors.add(n);
        }
        return primeFactors.stream().mapToInt(i -> i).toArray();
    }

    /**
     * Loop til sqrt(n): Create an arraylist. Run a loop from 2 till sqrt(n).
     * Divide n by i and add i to array list till n % i == 0
     * At last, if n >= 2, add it to the list (it takes care of the prime number > sqrt(n)
     *
     * TC: O(sqrt(n))
     * SC: O(1)
     *
     * @param n
     * @return
     */
    public static int[] allPrimeFactors(int n) {
        ArrayList<Integer> primeFactors = new ArrayList<>();

        for(int i = 2; i * i <= n; i = i + 1) {
            // while i divides n, add i and divide n
            while(n % i == 0) {
                if(!primeFactors.contains(i)) {
                    primeFactors.add(i);
                }
                n = n / i;
            }
        }

        if(n >= 2) {
            primeFactors.add(n);
        }
        return primeFactors.stream().mapToInt(i -> i).toArray();
    }
}
