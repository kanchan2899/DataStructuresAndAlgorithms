package com.dsalgo.recursion.numbers;

public class FloorOfLog2N {
    public static void main(String[] args) {
        int n = 31;
        System.out.println(log2N(n));
    }

    private static int log2N(int n) {
        if(n == 1) {
            return 0;
        }
        return 1 + log2N(n / 2);
    }
}
