package com.dsalgo.maths;

import java.util.Scanner;

public class IsPrime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the number: ");
        int n  = in.nextInt();
        System.out.println("Is number " + n + " prime ? : " + isPrime(n));
    }

    static boolean isPrime(int num){
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
