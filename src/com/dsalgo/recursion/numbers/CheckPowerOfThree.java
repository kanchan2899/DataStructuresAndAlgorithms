package com.dsalgo.recursion.numbers;

public class CheckPowerOfThree {
    public static void main(String[] args) {
        int[] x = {12, 91, 21};
        for(int n : x) {
            System.out.println("Can " + x + " " +
                    "be represented as the sum of distinct powers of three? " + checkPowerOfThree(n));
            System.out.println(checkPowerOfThree1(n));
        }
    }

    private static boolean checkPowerOfThree1(int n) {
        if (n == 0) {
            return true;
        }
        if(n % 3 == 2) {
            return false;
        }
        return checkPowerOfThree1(n / 3);
    }

    private static boolean checkPowerOfThree(int n) {
        return helper(n, 0);
    }

    private static boolean helper(int n, int pow) {
        if(n == 0)
            return true;
        int value = (int)Math.pow(3, pow);
        if(n < 0 || value > n)
            return false;
        if(helper(n, pow + 1) || helper(n - value, pow + 1))
            return true;
        return false;
    }
}
