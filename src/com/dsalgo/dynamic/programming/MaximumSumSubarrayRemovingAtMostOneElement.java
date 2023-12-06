package com.dsalgo.dynamic.programming;

// https://www.geeksforgeeks.org/maximum-sum-subarray-removing-one-element/
public class MaximumSumSubarrayRemovingAtMostOneElement {
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxSumSubarray(arr));
        System.out.println(maxSumSubarray1(arr));
    }

    /**
     * Using constant space and single pass
     *
     * curr represents current max sum including arr[i] -- either curr + arr[i] or arr[i]
     * (if arr[i] > curr + arr[i], meaning dp is negative, we just drop curr and start over from
     * arr[i] as there is no point to keep a negative sum)
     *
     * prev represents current max sum excluding arr[i] prev can be x + arr[i] since it already
     * excluded one element previously. Or, it can be
     *
     * previous curr, meaning we exclude current element -- arr[i].
     *
     * res keep track of the maximum sum seen so far
     *
     * At each ith index check wether to include that index in sum or not.
     *     For each element x in the array, calculate -:
     *         curr = maximum(prev, x + curr)
     *         prev = maximum(x, x + prev)
     *         res = maximum(res, maximum(curr, prev))
     *
     *     return res; // maximum sum of array with one deletion
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param arr
     * @return
     */
    private static int maxSumSubarray1(int[] arr) {
        int n = arr.length;

        int res = Integer.MIN_VALUE, prev = 0, curr = 0;

        for(int x : arr) {
            curr = Math.max(prev, x + curr);
            prev = Math.max(x, x + prev);
            res = Math.max(res, Math.max(curr, prev));
        }
        return res;
    }

    /**
     * Using prefix and suffix array
     *
     * 1. Initialize two arrays, one for prefix max sum fw[] and another for suffix max sum bw[].
     * 2. Run two for loops
     *      - First one to store the maximum current sum from prefix in fw[] and
     *      - The other loop stores the same for suffix in bw[].
     *      - Getting the current maximum and updating it is the same as Kadane’s algorithm.
     * 3. Now for one element removal iterate over each index i, calculate the maximum subarray
     * sum after ignoring ith element i.e. fw[i-1] + bw[i+1]
     * 4. So loop for all possible index i and choose the maximum among them.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param arr
     * @return
     */
    private static int maxSumSubarray(int[] arr) {
        int n = arr.length;
        // Maximum sum subarrays in forward and backward directions
        int[] fw = new int[n];
        int[] bw = new int[n];

        // Initialize current max and max so far.
        int curr_max = arr[0], max_so_far = arr[0];

        // Calculating maximum sum subarrays in forward direction
        fw[0] = arr[0];

        for(int i = 1; i < n; i++) {
            curr_max = Math.max(arr[i], curr_max + arr[i]);
            max_so_far = Math.max(max_so_far, curr_max);

            // Storing current maximum till ith, in forward array
            fw[i] = curr_max;
        }

        // Calculating maximum sum subarrays in backward direction
        curr_max = max_so_far = bw[n - 1] = arr[n - 1];

        for(int i = n - 2; i >= 0; i--) {
            curr_max = Math.max(arr[i], curr_max + arr[i]);
            max_so_far = Math.max(curr_max, max_so_far);

            // Storing current maximum from ith, in backward array
            bw[i] = curr_max;
        }

        //  Initializing final ans by max_so_far so that, case when no element is removed to get
        //  max sum subarray is also handled
        int fans = max_so_far;

        for(int i = 1; i < n - 1; i++) {
            fans = Math.max(fans, fw[i - 1] + bw[i + 1]);
        }
        return fans;
    }
}
