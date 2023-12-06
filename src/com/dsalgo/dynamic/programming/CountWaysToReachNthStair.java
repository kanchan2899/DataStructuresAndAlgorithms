package com.dsalgo.dynamic.programming;

import java.util.Arrays;

// https://www.geeksforgeeks.org/count-ways-reach-nth-stair/
public class CountWaysToReachNthStair {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(countWays(n));
        System.out.println(countWays1(n));
        System.out.println(countWays2(n));
    }

    /**
     * Using DP Tabulation:
     *
     * 1. Create a 1D dp where dp[i] represent the number of ways to reach the ith stair from the
     * bottom.
     * 2. Initialise dp[0] = 1, as there is only one way for n = 0 and dp[1] = 2 as there are only
     * 2 ways for input n = 2.
     * 3. Now for each i >= 2, dp[i] = dp[i-1]+dp[i-2]
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param n
     * @return
     */
    private static int countWays2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    /**
     * Using DP Memoization:
     *
     * 1. Create a 1D dp where dp[i] represent the number of ways to reach the ith stair from the
     * bottom.
     * 2. Check if answer for subproblem already exist or not in dp.
     * 3. Recursively call for subproblems and store their result in dp (i.e, dp[n] =
     * countWays(n – 1, dp) + countWays(n – 2, dp)).
     * 4. Finally, return dp[n], as it will store the answer for input n.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param n
     * @return
     */
    private static int countWays1(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper1(n, dp);
    }

    private static int helper1(int n, int[] dp) {
        if(n <= 1) {
            return dp[n] = 1;
        }
        if(dp[n] != -1) {
            return dp[n];
        }

        dp[n] = helper1(n - 1, dp) + helper1(n - 2, dp);
        return dp[n];
    }

    /**
     * Using recursion: The person can reach nth stair from either (n-1)th stair or from (n-2)th
     * stair. Hence, for each stair n, we try to find out the number of ways to reach n-1th stair
     * and n-2th stair and add them to give the answer for the nth stair. Therefore, the Recurrence
     * relation for such an approach comes out to be : ways(n) = ways(n-1) + ways(n-2)
     *
     * TC: O(2 ^ n)
     * SC: O(n)
     *
     * @param n
     * @return
     */
    private static int countWays(int n) {
        return helper(n + 1);
    }

    private static int helper(int i) {
        if(i <= 1) {
            return i;
        }
        return helper(i - 1) + helper(i - 2);
    }
}
