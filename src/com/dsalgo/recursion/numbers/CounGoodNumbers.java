package com.dsalgo.recursion.numbers;

public class CounGoodNumbers {
    static int mod = (int)(Math.pow(10, 9)) + 7;
    public static void main(String[] args) {
        long n = 50;
        System.out.println(countGoodNumbers(n));
    }

    /**
     * Here the patter is 5454545454...
     * Number of 4's = No. of odd positions = n / 2
     * Number of 5's = No. of even positions = n + 1 / 2 = n / 2 + n % 2
     * answer = power(4, # of 4's) * power(5, # of 5's)
     * @param n
     * @return
     */
    public static int countGoodNumbers(long n) {
        long odd = n / 2;
        long even = (n + 1) / 2;

        return (int)(power(4, odd) * power(5, even) % mod);
    }

    private static long power(long x, long n) {
        if(n == 0)
            return 1;
        long temp = power(x, n / 2);
        if(n % 2 == 0) {
            return (temp * temp) % mod;
        } else {
            return (x * temp * temp) % mod;
        }
    }
}
