package com.dsalgo.simple.programs;

import java.util.Scanner;

public class LargestNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter three numbers: ");
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        System.out.println("Largest number with largestNum1() function is " + largestNum1(a, b, c));
        System.out.println("Largest number with largestNum1() function is " + largestNum2(a, b, c));
        System.out.println("Largest number with largestNum1() function is " + largestNum3(a, b, c));
    }

    private static int largestNum1(int a, int b, int c){
        int max = a;
        if(b > max){
            max = b;
        }
        if(c > max){
            max = c;
        }
        return max;
    }

    private static int largestNum2(int a, int b, int c){
        int max = 0;
        if(a > b){
            max = a;
        } else {
            max = b;
        }
        if(c > max){
            max = c;
        }
        return max;
    }

    private static int largestNum3(int a, int b, int c) {
        return (Math.max(c, Math.max(a, b)));
    }

}
