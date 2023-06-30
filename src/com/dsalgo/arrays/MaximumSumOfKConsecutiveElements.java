package com.dsalgo.arrays;

public class MaximumSumOfKConsecutiveElements {
    public static void main(String[] args) {
        int[] arr = {1, 8, 30, -5, 20, 7};
        int k = 3;
        System.out.println(maxSum(arr, k));
        System.out.println(maxSum1(arr, k));
    }

    /**
     * Bruteforce: calculate sum for each of the blocks of K consecutive elements
     * and compare which block has the maximum sum possible.
     * The time complexity of this approach will be O(n * k).
     *
     * TC: O(n * k)
     * SC: O(1)
     * @param arr
     * @param k
     * @return
     */
    private static int maxSum(int[] arr, int k) {
        int max_sum = Integer.MIN_VALUE;

        for(int i = 0; i + k - 1 < arr.length; i++) {
            int current_sum = 0;
            for(int j = 0; j < k; j++) {
                current_sum += arr[i+j];
            }
            max_sum = Math.max(current_sum, max_sum);
        }
        return max_sum;
    }

    /**
     * Sliding window: The technique can be best understood with the window pane in bus,
     * consider a window of length n and the pane which is fixed in it of length k.
     * Consider, initially the pane is at extreme left i.e., at 0 units from the left.
     * Now, co-relate the window with array arr[] of size n
     * and plane with current_sum of size k elements.
     * Now, if we apply force on the window such that it moves a unit distance ahead.
     * The pane will cover next k consecutive elements.
     *
     * 1. We compute the sum of first k elements out of n terms using a linear loop and
     * store the sum in variable window_sum.
     * 2. Then we will graze linearly over the array till it reaches the end and
     * simultaneously keep track of maximum sum.
     * 3. To get the current sum of block of k elements just subtract the first element
     * from the previous block and add the last element of the current block .
     *
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param arr
     * @param k
     * @return
     */
    private static int maxSum1(int[] arr, int k) {
        int current_sum = 0;
        int max_sum = Integer.MIN_VALUE;

        for(int i = 0; i < k; i++) {
            current_sum += arr[i];
        }

        max_sum = Math.max(current_sum, max_sum);

        for(int i = k; i < arr.length; i++) {
            current_sum = current_sum + arr[i] - arr[i - k];
            max_sum = Math.max(current_sum, max_sum);
        }
        return max_sum;
    }
}
