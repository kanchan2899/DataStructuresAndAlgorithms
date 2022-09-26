package com.dsalgo.bit.manipulation;

public class DivideMultiply {
    public static void main(String[] args) {
        int a = 2;
        System.out.println(divide(a));
        System.out.println(multiply(a));
    }

    private static int multiply(int a) {
        return a >> 1;
    }

    private static int divide(int a) {
        return a << 1;
    }
}
