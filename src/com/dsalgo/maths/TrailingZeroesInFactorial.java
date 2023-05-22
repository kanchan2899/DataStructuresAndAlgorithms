package com.dsalgo.maths;

// https://practice.geeksforgeeks.org/problems/trailing-zeroes-in-factorial5134/1
public class TrailingZeroesInFactorial {
    public static void main(String[] args) {
        int n = 20;
        System.out.println(trailingZeroes(n));
        System.out.println(trailingZeroes1(n));
    }

    /**
     *  Bruteforce algo: Calculate the factorial first, and then count the number of zeroes in the
     *  factorial.
     *  This algo causes overflow problem and gives wrong results for n > 10 or 15
     *
     *  TC: O(n)
     *  SC: O(1)
     */
    private static int trailingZeroes1(int n) {
        long fact = 1;
        int count = 0;
        for(int i = 2; i <= n; i++) {
            fact = fact * i;
        }

        while (fact != 0) {
            long rem = fact % 10;
            if(rem == 0) {
                count++;
            } else {
                break;
            }
            fact = fact/10;
        }
        return count;
    }

    /**
     * Optimized approach: In 1 * 2 * 3 * 4 * 5 * 6 * 7 * 9 * 10 * ... * 25 * ... * n, a trailing
     * 0 is added when we have 2 * 5 combination. So we need to count only number of 2's and 5's.
     * We can easily observe that the number of 2's in prime factors is always more than or equal
     * to the number of 5's. So, if we count 5's in prime factors, we get the results.
     * But how to count the total number of 5's in prime factors of n!? A simple way is to calculate
     * floor(n / 5). But numbers like 25, 125.. have more than one 5's. Hence, first divide n by 5
     * and remove all single 5's, then divide by 25 to remove extra 5's and so on. Following is
     * the summarized formula for counting trailing zeroes.
     *
     * Hence, number of trailing zeroes = Count of 5's in prime factors on n! =
     *      floor(n / 5) + floor(n / 25) + floor(n / 125) ...
     *
     *
     *
     * TC: O(log n)
     * SC: O(1)
     * @param N
     * @return
     */
    static int trailingZeroes(int N){
        int count = 0;
        for(int i = 5; i <= N; i = i * 5) {
            count = count + (N / i);
        }
        return count;
    }
}
