package com.dsalgo.bit.manipulation;

// Check whether a number is even or odd
// https://www.geeksforgeeks.org/check-if-a-number-is-odd-or-even-using-bitwise-operators/
public class EvenOrOdd {
    public static void main(String[] args) {
        int[] n = {9, 100, 16, 15, 14, 18, 205};
        for(int a : n){
            System.out.println(isOdd(a));
        }
    }

    private static boolean isOdd(int a) {
        return (a & 1) == 0;
    }
}
