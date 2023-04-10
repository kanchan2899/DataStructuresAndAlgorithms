package com.dsalgo.recursion.numbers;

public class PowerOfThree {

    public static void main(String[] args) {
        int[] n = {27, 19, 81, 3};
        for(int s : n){
            System.out.println(isPowerOfThree(s));
        }
    }

    private static boolean isPowerOfThree(int n) {
        if(n == 0)
            return false;
        if(n == 1)
            return true;
        if(n % 3 == 0){
            return isPowerOfThree(n/3);
        }
        return false;
    }
}
