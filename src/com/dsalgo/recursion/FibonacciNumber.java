package com.dsalgo.recursion;

public class FibonacciNumber {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(fibonacci(n));
        System.out.println(fibonacciFormula(50));
    }

    private static long fibonacciFormula(int n){
         // return  Math.pow(((1 + Math.sqrt(5)) / 2), n);
        // return (int) ((Math.pow(((1 + Math.sqrt(5)) / 2), n) - Math.pow(((1 - Math.sqrt(5)) / 2), n)) / Math.sqrt(5));
        return (long) ((Math.pow(((1 + Math.sqrt(5)) / 2), n)) / Math.sqrt(5));
    }
    private static int fibonacci(int n) {
        if(n < 2){
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
