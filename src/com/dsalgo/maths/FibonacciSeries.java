package com.dsalgo.maths;

import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        System.out.print("Please enter the index of Fibonacci series:  ");
        int n = in.nextInt();
        int a = 0;
        int b = 1;
//        int count = 2;
//        while(count <= n){
//            int temp = b;
//            b = b + a;
//            a = temp;
//            count++;
//        }
        int countIndex = 2;
        while(countIndex <= n){
            int temp = b;
            b = b + a;
            a = temp;
            countIndex++;
        }
        System.out.println(b);
    }
}
