package com.dsalgo.maths;

// https://practice.geeksforgeeks.org/problems/all-divisors-of-a-number/1
public class AllDivisors {
    public static void main(String[] args) {
        int n = 10;
        printDivisors(n);
        System.out.println();
        printDivisors1(n);
        System.out.println();
        printDivisors2(n);
    }

    private static void printDivisors2(int n) {
        int i;
        if(n == 1) {
            System.out.print(n);
            return;
        }
        for(i = 1; i * i < n; i++) {
            if(n % i == 0) {
                System.out.print(i + " ");
            }
        }

        if(i != Math.sqrt(n)) {
            i--;
        }
        for(; i >= 1; i--) {
            if(n % i == 0) {
                System.out.print(n / i + " ");
            }
        }
    }

    private static void printDivisors(int n) {
        for(int i = 1; i <= n; i++) {
            if(n % i == 0){
                System.out.print(i + " ");
            }
        }
    }

    private static void printDivisors1(int n) {
        for(int i = 1; i * i <= n; i++) {
            if(n % i == 0){
                System.out.print(i + " ");
                if(i != Math.floor(n / i)) {
                    System.out.print(n/i + " ");
                }
            }

        }
    }
}
