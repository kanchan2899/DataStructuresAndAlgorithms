package com.dsalgo.recursion.numbers;

// https://www.geeksforgeeks.org/sum-of-natural-numbers-using-recursion/
public class SumOfN {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(sumOfN(n));
    }

    private static int sumOfN(int n) {
        if(n < 1)
            return 0;
        return n + sumOfN(n - 1);
    }
}
