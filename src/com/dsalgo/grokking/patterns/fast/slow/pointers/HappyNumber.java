package com.dsalgo.grokking.patterns.fast.slow.pointers;

// https://leetcode.com/problems/happy-number/
public class HappyNumber {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(happyNumber(n));
    }

    private static boolean happyNumber(int n) {
        int slow = n, fast = squareNumber(n);

        while (fast != 1 && fast != slow) {
            slow = squareNumber(slow);
            fast = squareNumber(squareNumber(fast));
        }
        return fast == 1;
    }

    private static int squareNumber(int n) {
        int sum = 0;
        while (n > 0) {
            int rem = n % 10;
            sum = sum + rem * rem;
            n /= 10;
        }
        return sum;
    }
}
