package com.dsalgo.recursion.numbers;

// https://leetcode.com/problems/minimum-non-zero-product-of-the-array-elements/description/
public class MinimumNonZeroProductOfTheArrayElements {
    static long mod = 100000007L;
    public static void main(String[] args) {
        int p = 4;
        System.out.println(minNonZeroProduct(p));
    }

    /*
        Here, the brute-force approach would be to change all the numbers to binary form and
        try to change the numbers in the binary representation bit by bit. It is simply inconvenient
        and not the optimized solution.
     */
    /**
     *  Using mathematical pattern:
     *  E.g. p = 3, the potential numbers will be in the range [1, 2^p - 1] = [1, 7]
     *
     *  initial      first   second
     *  1 = 001      001     001
     *  2 = 010      110     110
     *  3 = 011      001     001
     *
     *  4 = 100      100     110
     *  5 = 101      001     001
     *  6 = 110      110     110
     *
     *  7 = 111      111     111
     *
     *  In the first operation we can swap the leftmost bit of the second and fifth elements.
     * - The resulting array is [001, 110, 011, 100, 001, 110, 111].
     *
     * In the second operation we can swap the middle bit of the third and fourth elements.
     * - The resulting array is [001, 110, 001, 110, 001, 110, 111].
     *
     * The array product is 1 * 6 * 1 * 6 * 1 * 6 * 7 = 1512, which is the minimum possible product.
     *
     * We have changed three numbers to 1 and another 3 numbers to 6 and leave the maximum 7 unchanged.
     * So at the end pattern becomes, there will be mid = (2 ^ p - 1) / 2
     * number of both 1's and 2^p - 2 and one maxm = 2^p - 1, which means the product will become:
     *
     * product = 1 * 1 * 1 ... [mid times]  * maxm - 1 * maxm - 1 .... [mid times] * maxm
     *
     * TC: O(log n)
     * SC: O(1)
     *
     * @param p
     * @return
     */
    public static int minNonZeroProduct(int p) {
        if(p == 1)
            return 1;
        long lastNumberInArray = (1 << p) - 1;
        long result = (lastNumberInArray % mod) * binaryExponential(lastNumberInArray - 1, lastNumberInArray / 2);
        return (int) (result % mod);
    }

    static long binaryExponential(long x, long n) {
        long result = 1;
        if(x == 0) {
            return 0;
        }
        while(n > 0) {
            if(n % 2 != 0) {
                result = ((result % mod) * (x % mod)) % mod;
            }
            x = ((x % mod) * (x % mod)) % mod;
            n >>= 1;
        }
        return (result % mod);
    }
}
