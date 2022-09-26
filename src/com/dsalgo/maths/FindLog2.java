package com.dsalgo.maths;


// https://www.geeksforgeeks.org/how-to-calculate-log-base-2-of-an-integer-in-java/
public class FindLog2 {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(log2(n));
    }

    private static double log2(int n) {
        return (Math.log(n) / Math.log(2));
    }
}
