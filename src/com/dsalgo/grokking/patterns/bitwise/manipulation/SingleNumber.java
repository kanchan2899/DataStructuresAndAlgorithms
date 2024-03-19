package com.dsalgo.grokking.patterns.bitwise.manipulation;

public class SingleNumber {
    public static void main(String[] args) {
        int[] arr = {2, 4, 2, 3, 4, 5, 6, 5, 6};
        System.out.println(singleNumber(arr));
    }

    private static int singleNumber(int[] arr) {
        int result = 0;
        for(int x: arr) {
            result ^= x;
        }
        return result;
    }
}
