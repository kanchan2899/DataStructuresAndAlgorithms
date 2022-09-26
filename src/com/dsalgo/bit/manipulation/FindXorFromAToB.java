package com.dsalgo.bit.manipulation;

// https://www.geeksforgeeks.org/find-xor-of-numbers-from-the-range-l-r/
public class FindXorFromAToB {
    public static void main(String[] args) {
        int a = 3;
        int b = 7;
        System.out.println(findXor(a, b));
    }

    private static int findXor(int a, int b) {
        return findXor0toA(b) ^ findXor0toA(a - 1);
    }

    private static int findXor0toA(int a) {
        if(a % 4 == 0)
            return a;
        if(a % 4 == 1)
            return 1;
        if(a % 4 == 2)
            return a+1;
        return 0;
    }


}
