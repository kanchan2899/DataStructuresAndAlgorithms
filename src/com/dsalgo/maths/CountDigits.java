package com.dsalgo.maths;

import java.util.Scanner;

// https://practice.geeksforgeeks.org/problems/count-digits5716/1
public class CountDigits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        System.out.println("Number of digits in " + num + " is " + countDigits(num));
        System.out.println("Number of digits in " + num + " is " + countDigits1(num));
    }

    private static int countDigits1(int num) {
        return (int) Math.log10(num) + 1;
    }

    private static int countDigits(int num) {
        int digits = 0;
        if(num < 0) {
            num = -num;
        }
        while(num > 0){
            num = num / 10;
            digits++;
        }
        return digits;
    }
}
