package com.dsalgo.maths;

import java.util.Scanner;


// https://www.geeksforgeeks.org/prime-numbers/
public class IsPrime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the number: ");
        int n  = in.nextInt();
        System.out.println("Is number " + n + " prime using brute force algo? : " + bruteforce_isPrime(n));
        System.out.println("Is number " + n + " prime by checking numbers till sqrt(n) ? : " + improved_bruteforce_isPrime(n));
        System.out.println("Is number " + n + " prime for large value of n ? : " + isPrime(n));
    }

    /**
     * Optimized solution for large value of n: The idea is to check n % 2 == 0 and n % 3 == 0,
     * then we can save many iterations for large numbers
     *
     * @param n
     * @return
     */
    private static boolean isPrime(int n) {
        if(n == 1)
            return false;
        if(n == 2 || n == 3)
            return true;
        if(n % 2 == 0 || n % 3 == 0)
            return false;
        for(int i = 5; i * i <= n; i = i + 6) {
            if(n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * Brute-force algo: Check from number 2 till num if the module of number and num gives 0,
     * number is not prime. Otherwise, it is prime.
     *
     * @param num to check if it is prime
     * @return boolean to indicate if num is prime
     */
    static boolean bruteforce_isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        int c = 2;
        while(c < num) {
            if(num % c == 0) {
                return false;
            }
            c++;
        }
        return true;
    }

    /**
     * Improved Brute-force algo: Check from number 2 till square root of num [sqrt(num)] if the module of number and num gives 0,
     * number is not prime. Otherwise, it is prime.
     * The idea is divisors always appear in pairs, hence we need to check only one pair
     * Example: num = 36
     * 1 * 36 = 36
     * 2 * 18 = 36
     * 3 * 12 = 36
     * 4 * 9 = 36
     * 6 * 6 = 36
     * 9 * 4 = 36 (already checked in step 4)
     * 12 * 3 = 36 (already checked in step 3)
     * 18 * 2 = 36 (already checked in step 2)
     * 36 * 1 = 36 (already checked in step 1)
     * Hence, it makes sense to run the loop from 2 till sqrt(36), which is 6.
     *
     * @param num to check if it is prime
     * @return boolean to indicate if num is prime
     */
    static boolean improved_bruteforce_isPrime(int num){
        if (num <= 1 ){
            return false;
        }
        int c = 2;
        while (c * c <= num ){
            if (num % c == 0){
                return false;
            }
            c++;
        }
        return true; // return c * c > num
    }
}
