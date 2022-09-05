package com.dsalgo.recursion;

// https://www.geeksforgeeks.org/product-2-numbers-using-recursion/
public class ProductOfNumbers {
    public static void main(String[] args) {
        int x = 100;
        int y = 5;
        System.out.println(product(x, y));
    }

    private static int product(int x, int y) {
        if(y <= 0){
            return 0;
        }
        return x + product(x, y - 1);
    }
}
