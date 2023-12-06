package com.dsalgo.dynamic.programming;

// https://www.geeksforgeeks.org/program-nth-catalan-number/
public class NthCatalanNumber {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(nthCatalanNumber(n));
        System.out.println(nthCatalanNumber1(n));
    }

    /**
     * Using DP - Tabulation
     *
     * 1. Create an array catalan[] for storing ith Catalan number.
     * 2. Initialize, catalan[0] and catalan[1] = 1
     * 3. Loop through i = 2 to the given Catalan number n.
     *      a. Loop through j = 0 to j < i and Keep adding value of catalan[j] * catalan[i – j – 1]
     *      into catalan[i].
     * 4. Finally, return catalan[n]
     *
     * TC: O(n ^ 2)
     * SC: O(n)
     *
     * @param n
     * @return
     */
    private static int nthCatalanNumber1(int n) {
        // Table to store results of sub-problems
        int[] catalan = new int[n + 2];

        // Initialize first two values in table
        catalan[0] = catalan[1] = 1;

        for(int i = 2; i <= n; i++) {
            catalan[i] = 0;
            for(int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }

        return catalan[n];
    }

    /**
     * Using recursion:
     *
     * Catalan numbers satisfy the following recursive formula:
     * C_0 = 1
     * C_N+1 = summation i = 0 -> n (C_i * C_n-i) for n >= 0
     *
     * 1. Base condition for the recursive approach, when n <= 1, return 1
     * 2. Iterate from i = 0 to i < n
     *      a. Make a recursive call catalan(i) and catalan(n – i – 1) and keep adding the product of both into res.
     * 3. Return the res.
     *
     * TC: O
     * SC: O(n)
     *
     * @param n
     * @return
     */
    private static int nthCatalanNumber(int n) {
        int res = 0;
        if(n <= 1) {
            return 1;
        }

        for(int i = 0; i < n; i++) {
            res += nthCatalanNumber(i) * nthCatalanNumber(n - i - 1);
        }
        return res;
    }
}
