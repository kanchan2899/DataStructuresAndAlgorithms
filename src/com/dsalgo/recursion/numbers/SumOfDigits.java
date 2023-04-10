package com.dsalgo.recursion.numbers;

// https://www.geeksforgeeks.org/sum-digit-number-using-recursion/
public class SumOfDigits {
    public static void main(String[] args) {
        int x = 12345;
        System.out.println(sum(x));
        System.out.println(sum1(x));
    }

    private static int sum1(int x) {
        if(x <= 0) {
            return 0;
        }
        int count = x % 10;
        count = count + sum1(x/10);
        return count;
    }

    private static int sum(int x) {
        if(x <= 0)
            return 0;
        int rem = x % 10;
        return rem + sum(x/10);
    }
}
