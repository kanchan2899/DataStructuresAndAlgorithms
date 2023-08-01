package com.dsalgo.grokking.patterns.mege.intervals;

import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1
public class MinimumPlatforms {
    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(findPlatform(arr, dep, arr.length));
    }

    /**
     * Using merge intervals algo
     *
     * TC: O(n * log n)
     * SC: O(1)
     *
     * @param arr
     * @param dep
     * @param n
     * @return
     */
    static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int current = 1, ans = Integer.MIN_VALUE;
        int i = 1, j = 0;

        while(i < n && j < n) {
            if(arr[i] <= dep[j]) {
                current++;
                i++;
            } else {
                current--;
                j++;
            }

            ans = Math.max(ans, current);
        }
        return ans;
    }
}
