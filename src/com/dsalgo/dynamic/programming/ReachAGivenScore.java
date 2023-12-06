package com.dsalgo.dynamic.programming;

// https://www.geeksforgeeks.org/count-number-ways-reach-given-score-game/
public class ReachAGivenScore {
    public static void main(String[] args) {
        int n = 20;
        System.out.println(count(n));
    }

    /**
     * Using DP - Tabulation
     *
     * 1. Create an array table[] of size N+1 to store counts of all scores from 0 to N.
     * 2. For every possible move (3, 5, and 10), increment the number of ways to reach the
     * current score x i.e. table[x] with ways in which those scores can be reached from
     * where x is reachable i.e. (x – 3), (x – 5), (x – 10).
     * 3. Return table[N] .
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param n
     * @return
     */
    private static int count(int n) {
        int[] dp = new int[n + 1];
        int i;
        dp[0] = 1;

        for(i = 3; i <= n; i++) {
            dp[i] += dp[i - 3];
        }
        for(i = 5; i <= n; i++) {
            dp[i] += dp[i - 5];
        }
        for(i = 10; i <= n; i++) {
            dp[i] += dp[i - 10];
        }

        return dp[n];
    }
}
