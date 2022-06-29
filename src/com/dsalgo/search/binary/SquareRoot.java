package com.dsalgo.search.binary;

import java.util.Scanner;
import java.util.stream.IntStream;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        System.out.println("Square root of " + num + " is " + squareRoot(num));
    }

    private static int squareRoot(int num) {
        int start = 1;
        int end = num;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(mid * mid == num) return mid;
            else if(mid * mid > num) end = mid - 1;
            else start = mid + 1;
        }
        return start - 1;
    }
}
