package com.dsalgo.recursion.numbers;

public class DigitalRoot {
    public static void main(String[] args) {
        int n = 1234;
        System.out.println(digitalRoot(n));
    }

    private static int digitalRoot(int n) {
        if(n >= 0 && n <= 9) {
            return n;
        }
        int x = n, count = 0;
        while(x != 0) {
            count =  count + x % 10;
            x = x / 10;
        }
        return digitalRoot(count);
    }
}
