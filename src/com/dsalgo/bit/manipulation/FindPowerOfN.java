package com.dsalgo.bit.manipulation;

// https://www.geeksforgeeks.org/fast-exponention-using-bit-manipulation/
public class FindPowerOfN {
    public static void main(String[] args) {
        int a = 2;
        int b = 5;
        System.out.println(findPower(a, b));
    }

    private static long findPower(int a, int b) {
        long ans = 1;
        while(b > 0) {
            if((b & 1) == 1) {
                ans = ans * a;
            }
            a = a * a;
            b = b >> 1;
        }
        return ans;
    }
}
