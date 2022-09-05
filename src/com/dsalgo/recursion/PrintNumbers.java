package com.dsalgo.recursion;

public class PrintNumbers {
    public static void main(String[] args) {
        int n = 10;
        printNumbers(n);
    }

    private static int printNumbers(int n) {
        if(n <= 0)
            return 0;
        System.out.println(n);
        return printNumbers(n - 1);
    }
}
