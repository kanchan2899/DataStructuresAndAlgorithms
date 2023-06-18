package com.dsalgo.maths;

import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the number to reverse: ");
        int num = in.nextInt();
        System.out.println("The reversed number is " + reverseNum(num));
    }

    private static int reverseNum(int num) {
        int reverse = 0;
        while(num > 0){
            int rem = num % 10;
            reverse = reverse * 10 + rem;
            num /= 10;
        }
        return reverse;
    }
}
