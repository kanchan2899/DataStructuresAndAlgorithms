package com.dsalgo.recursion.numbers;

public class CountZeroes {
    public static void main(String[] args) {
        int n = -3032020;
        System.out.println(countZeroes1(n));
        System.out.println(countZeroes2(n));
    }

    private static int countZeroes2(int n) {
        return helper(n, 0);
    }

    private static int helper(int n, int count) {
        if(n == 0)
            return count;
        return n%10 == 0 ? helper(n/10, count + 1) : helper(n/10, count);
    }

    private static int countZeroes1(int n) {
        if(n == 0)
            return 0;
        int isRemZero = n % 10 == 0 ? 1 : 0;
        return isRemZero + countZeroes1(n / 10);
    }
}
