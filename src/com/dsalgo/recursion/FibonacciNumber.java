package com.dsalgo.recursion;

public class FibonacciNumber {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(fibonacci(6));
    }

    private static int fibonacci(int n) {
        if(n == 1 || n == 0){
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
