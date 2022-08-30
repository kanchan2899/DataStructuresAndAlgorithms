package com.dsalgo.recursion;

// https://www.geeksforgeeks.org/sum-digit-number-using-recursion/
public class SumOfDigits {
    public static void main(String[] args) {
        int x = 12345;
        System.out.println(sum(x));
    }

    private static int sum(int x) {
        if(x <= 0)
            return 0;
        int rem = x % 10;
        return rem + sum(x/10);
    }
}
