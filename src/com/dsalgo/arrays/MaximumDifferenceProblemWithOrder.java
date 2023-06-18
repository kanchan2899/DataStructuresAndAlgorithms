package com.dsalgo.arrays;

// https://practice.geeksforgeeks.org/problems/maximum-difference-10429/1
public class MaximumDifferenceProblemWithOrder {
    public static void main(String[] args) {
        int[] arr = {2, 3, 10, 6, 4, 8, 1};
        System.out.println(maxDifference(arr, arr.length));
        System.out.println(maxDifference1(arr, arr.length));
    }

    /**
     * Instead of taking difference of the picked element with every other element, take the difference
     * with the minimum element found so far.
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param arr
     * @param n
     * @return
     */
    private static int maxDifference1(int[] arr, int n) {
        int maxDiff = arr[1] - arr[0];
        int minVal = arr[0];

        for(int i = 1; i < n; i++) {
            maxDiff = Math.max(maxDiff, arr[i] - minVal);
            minVal = Math.min(minVal, arr[i]);
        }
        return maxDiff;
    }

    /**
     * Bruteforce: Intialize a max_diff as arr[1] - arr[0].
     * Start a loop i from i to n - 2, start an inner loop j from i + 1 to n - 1.
     * if arr[j] - arr[i] > max_diff, max_diff = arr[j] - arr[i]
     * Return max_diff
     *
     * TC: O(n^2)
     * SC: O(1)
     *
     * @param arr
     * @param n
     * @return
     */
    private static int maxDifference(int[] arr, int n) {
        int maxDiff = arr[1] - arr[0];
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                maxDiff = Math.max(arr[j] - arr[i], maxDiff);

            }
        }
        return maxDiff;
    }


}
