package com.dsalgo.recursion.numbers;

public class DecimalToBinary {
    public static void main(String[] args) {
        int n = 10;
        convertToBinary(n);
    }

    private static void convertToBinary(int n) {
        if(n == 0)
            return;
        convertToBinary(n / 2);
        System.out.print(n % 2);
    }
}
