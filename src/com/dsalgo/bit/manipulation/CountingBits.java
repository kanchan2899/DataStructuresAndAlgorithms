package com.dsalgo.bit.manipulation;

import java.util.Arrays;

// https://leetcode.com/problems/counting-bits/
public class CountingBits {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(Arrays.toString(countBits(n)));
        System.out.println(Arrays.toString(countBits1(n)));
        System.out.println(countBits2(n));
    }

    private static int countBits2(int n) {
        if(n == 0)
            return 0;
        int x = (int)(Math.log(n) / Math.log(2));
        int mul = 1 << (x - 1);
        return mul * x + (n - (1 << x) + 1) + countBits2(n - (1 << x));

    }

    private static int[] countBits1(int n) {
        int[] ans = new int[n + 1];
        for(int i = 0; i < ans.length; i++){
            if(i % 2 == 0){
                ans[i] = ans[i / 2];
            } else {
                ans[i] = ans[i / 2] + 1;
            }
        }
        return ans;
    }

    private static int[] countBits(int n) {
        int ans[] = new int[n + 1];
        for(int i = 0; i < ans.length; i++){
            ans[i] = count(i);
        }
        return ans;
    }

    private static int count(int i) {
        int c = 0;
        while (i > 0) {
            if(i % 2 == 1) {
                c++;
            }
            i = i >> 1;
        }
        return c;
    }
}
