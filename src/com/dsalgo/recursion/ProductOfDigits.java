package com.dsalgo.recursion;

public class ProductOfDigits {
    public static void main(String[] args) {
        int n = 505;
        System.out.println(productOfDigits(n));
    }

    private static int productOfDigits(int n) {
        if(n == 0)
            return 1;
        return (n%10) * productOfDigits(n/10);
    }
}
