package com.dsalgo.bit.manipulation;

// https://www.geeksforgeeks.org/calculate-xor-1-n/
public class FindXorFrom0ToA {

    public static void main(String[] args) {
        int a = 5;
        System.out.println(xorOfN(a));
    }

    private static int xorOfN(int a) {
        if(a % 4 == 0)
            return a;
        if(a % 4 == 1)
            return 1;
        if(a % 4 == 2)
            return a + 1;
        return 0;
    }
}
