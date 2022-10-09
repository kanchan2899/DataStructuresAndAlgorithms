package com.dsalgo.recursion;

public class CountZeroes {
    public static void main(String[] args) {
        int n = -30204;
        System.out.println(countZeroes(n));
    }

    private static int countZeroes(int n) {
        if(n == 0)
            return 0;
        int isRemZero = n % 10 == 0 ? 1 : 0;
        return isRemZero + countZeroes(n / 10);
    }
}
