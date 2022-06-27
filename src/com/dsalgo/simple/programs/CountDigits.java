package com.dsalgo.simple.programs;

import java.util.Scanner;

public class CountDigits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        System.out.println("Number of digits in " + num + " is " + countDigits(num));
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
