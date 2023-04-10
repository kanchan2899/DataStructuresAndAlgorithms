package com.dsalgo.recursion.numbers;

import java.util.Scanner;

public class GeekonacciNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int n = sc.nextInt();
            int ans = geekonacciNumber(a, b, c, n);
            System.out.println(ans);
            t--;
        }
    }

    private static int geekonacciNumber(int a, int b, int c, int n) {
        if(n == 1) {
            return a;
        }
        if(n == 2) {
            return b;
        }
        if (n == 3) {
            return c;
        }
        return geekonacciNumber(a, b, c, n - 1) +
                geekonacciNumber(a, b, c, n - 2) +
                 geekonacciNumber(a, b, c, n - 3);
    }
}
