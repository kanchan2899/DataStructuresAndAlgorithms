package com.dsalgo.maths;

// https://practice.geeksforgeeks.org/batch/dsa-4/track/DSASP-Mathematics/problem/exactly-3-divisors
public class Exactly3Divisors {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(exactly3Divisors(n));
        System.out.println(exactly3Divisors1(n));
    }

    public static int exactly3Divisors(int n) {
        int count = 0;
        for(int i = 1; i <= n; i++) {
            int numOfDivisors = 0;
            for(int j = 1; j <= i; j++) {
                if(i % j == 0) {
                    numOfDivisors++;
                }
            }
            if(numOfDivisors == 3) {
                count++;
            }
        }

        return count;
    }

    public static int exactly3Divisors1(int n) {
        int ans = 0;
        for(int i = 2; i * i <= n; i++) {
            boolean flag = true;
            for(int j = 2; j * j <= i; j++) {
                if(i % j == 0) {
                    flag = false;
                }
            }
            if(flag) {
                ans++;
            }
        }
        return ans;
    }
}
