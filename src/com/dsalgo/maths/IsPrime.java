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
