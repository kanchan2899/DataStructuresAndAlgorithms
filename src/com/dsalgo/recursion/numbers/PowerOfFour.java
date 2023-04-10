package com.dsalgo.recursion.numbers;

public class PowerOfFour {
    public static void main(String[] args) {
        int[] x = {16, 5, 1};
        for(int n: x) {
            System.out.println("Is " + n + " a power of 4? " + isPowerOfFour(n));
        }
    }

    private static boolean isPowerOfFour(int n) {
        if(n == 0)
            return false;
        if(n == 1)
            return true;
        if(n % 4 == 0){
            return isPowerOfFour(n/4);
        }
        return false;
    }
}
