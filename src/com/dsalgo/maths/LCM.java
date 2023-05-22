package com.dsalgo.maths;

public class LCM {
    public static void main(String[] args) {
        int a = 10, b = 6;
        System.out.println(lcm1(a, b));
        System.out.println(lcm2(a, b));
    }

    private static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    private static int lcm2(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    private static int lcm1(int a, int b) {
        int res = Math.max(a, b);
        while (true) {
            if(res % a == 0 && res % b == 0) {
                return res;
            }
            res++;
        }
    }
}
