package com.dsalgo.dynamic.programming;

// https://www.geeksforgeeks.org/maximise-number-of-cuts-in-a-rod-if-it-can-be-cut-only-in-given-3-sizes/
public class MaximumCuts {
    public static void main(String[] args) {
        int n = 23, a = 12, b = 11, c = 13;
        System.out.println(maximumCuts(n, a, b, c));
        System.out.println(maximumCuts1(n, a, b, c));
    }

    /**
     * Using DP - Tabulation
     *
     * 1. Initialise an array DP[]={-1} and DP[0]=0.
     * 2. Run a loop from '1' to 'l'
     *  - If DP[i]=-1 means it's not possible to divide it using giving segments p,q,r so continue;
     *  - DP[i+p]=max(DP[i+p],DP[i]+1)
     *  - DP[i+q]=max(DP[i+q],DP[i]+1)
     *  - DP[i+r]=max(DP[i+r],DP[i]+1)
     * 3. print DP[l]
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param n
     * @param a
     * @param b
     * @param c
     * @return
     */
    private static int maximumCuts1(int n, int a, int b, int c) {
        int dp[] = new int[n + 1];
        dp[0] = 0;

        for(int i = 1; i <= n; i++) {
            dp[i] = -1;

            if(i - a >= 0)
                dp[i] = Math.max(dp[i], dp[i - a]);
            if(i - b >= 0)
                dp[i] = Math.max(dp[i], dp[i - b]);
            if(i - c >= 0)
                dp[i] = Math.max(dp[i], dp[i - c]);

            if(dp[i] != -1) {
                dp[i]++;
            }
        }
        return dp[n];
    }

    private static int maximumCuts(int n, int a, int b, int c) {
        if(n < 0) return -1;
        if(n == 0) return 0;

        int cuts = Math.max(maximumCuts(n - a, a, b, c),
                Math.max(maximumCuts(n - b, a, b, c), maximumCuts(n - c, a, b, c)));
        if(cuts == -1) return cuts;
        else return cuts + 1;
    }
}
