package com.dsalgo.dynamic.programming;

import java.util.Arrays;

// https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {50, 3, 10, 7, 40, 80};
        System.out.println(longestIncreasingSequence(arr));
        System.out.println(longestIncreasingSequence1(arr));
        System.out.println(longestIncreasingSequence2(arr));
        System.out.println(longestIncreasingSequence3(arr));
    }

    private static int longestIncreasingSequence3(int[] arr) {
        int[] tailTable = new int[arr.length];
        int len;    // always point to the empty slot

        tailTable[0] = arr[0];
        len = 1;

        for(int  i = 1; i < arr.length; i++) {
            if(arr[i] < tailTable[0]) {
                // new smallest value
                tailTable[0] = arr[i];
            } else if (arr[i] > tailTable[len - 1]) {
                // arr[i] wants to extend largest subsequence
                tailTable[len++] = arr[i];
            } else {
                // arr[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable
                int ceilIndex = ceilIndex(tailTable, 0, len - 1, arr[i]);
                tailTable[ceilIndex] = arr[i];
            }
        }
        return len;
    }

    private static int ceilIndex(int[] tailTable, int l, int r, int x) {
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if(tailTable[m] >= x) {
                r = m;
            } else {
                l = m;
            }
        }
        return r;
    }

    /**
     * Using DP - Tabulation
     *
     * TC: O( n ^ 2)
     * SC: O(n)
     * @param arr
     * @return
     */
    private static int longestIncreasingSequence2(int[] arr) {
        int[] lis = new int[arr.length];
        int i, j, max = 0;

        // Initialize LIS values for all indexes
        Arrays.fill(lis, 1);

        // compute optimized LIS values in bottom up manner
        for(i = 1; i < arr.length; i++) {
            for(j = 0; j < i; j++) {
                if(arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        // pick maximum of all LIS values
        for(i = 0; i < arr.length; i++) {
            if(max < lis[i]) {
                max = lis[i];
            }
        }
        return max;
    }

    /**
     * Using DP - Memoization
     *
     * TC: O( n ^ 2)
     * SC: O(n)
     *
     * @param arr
     * @return
     */
    private static int longestIncreasingSequence1(int[] arr) {
        int[][] mem = new int[arr.length + 1][arr.length + 1];

        for(int[] row : mem) {
            Arrays.fill(row, -1);
        }
        return helper1(arr, mem, 0, -1, arr.length);
    }

    private static int helper1(int[] arr, int[][] mem, int index, int prev_index, int n) {
        if(index == n) {
            return 0;
        }

        if(mem[index][prev_index + 1] != -1) {
            return mem[index][prev_index + 1];
        }

        int notTaken = helper1(arr, mem, index + 1, prev_index, n);
        int take = Integer.MIN_VALUE;

        if(prev_index == -1 || arr[index] > arr[prev_index]) {
            take = 1 + helper1(arr, mem, index + 1, index, n);
        }

        return mem[index][prev_index + 1] = Math.max(take, notTaken);
    }

    /**
     * Using Recursion:
     *
     * 1. Let L(i) be the length of the LIS ending at index i such that arr[i] is the last element
     * of the LIS. Then, L(i) can be recursively written as:
     *      a. L(i) = 1 + max(L(j) ) where 0 < j < i and arr[j] < arr[i]; or
     *      b. L(i) = 1, if no such j exists.
     * 2. Formally, the length of LIS ending at index i, is 1 greater than the maximum of lengths
     * of all LIS ending at some index j such that arr[j] < arr[i] where j < i.
     *
     * Steps:
     *
     * 1. Create a recursive function.
     * 2. For each recursive call, Iterate from the i = 1 to the current position and do the following:
     *      a. Find the possible length of the longest increasing subsequence ending at the current position if the previous sequence ended at i.
     *      b. Update the maximum possible length accordingly.
     * 3. Repeat this for all indices and find the answer
     *
     * TC: O(2 ^ n)
     * SC: O(1)
     *
     * @param arr
     * @return
     */
    static int max_ref;
    private static int longestIncreasingSequence(int[] arr) {
        // max_ref holds the result
        max_ref = 1;

        helper(arr, arr.length);

        return max_ref;
    }

    private static int helper(int[] arr, int n) {
        if(n == 1) {
            return 1;
        }

        // max_ending_here is the length of the LIS ending with arr[n - 1]
        int res, max_ending_here = 1;

        // recursively get all LIS ending with arr[0], arr[1] ... arr[n - 2]. If arr[i - 1] is smaller
        // than arr[n - 1], and max ending with arr[n - 1] needs to be updated, then update it.
        for(int i = 1; i < n; i++) {
            res = helper(arr, i);
            if(arr[i - 1] < arr[n - 1] && res + 1 > max_ending_here) {
                max_ending_here = res + 1;
            }
        }

        // compare max_ending_here with the overall max and update the overall max if needed
        if(max_ending_here > max_ref) {
            max_ref = max_ending_here;
        }

        // return the length of LIS ending with arr[n - 1]
        return max_ending_here;
    }
}
