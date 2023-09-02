package com.dsalgo.stacks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// https://www.geeksforgeeks.org/find-the-maximum-of-minimums-for-every-window-size-in-a-given-array/
public class MaximumOfMinimumForEveryWindowSize {

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 50, 10, 70, 30};
        maxOfMin(arr);
        System.out.println(Arrays.toString(maxOfMin1(arr)));
    }

    /**
     * Using stack: The idea is to find the next smaller and previous smaller of each element
     * and update the maximum of window with size as the difference in their indices.
     *
     *
     * @param arr
     */
    private static int[] maxOfMin1(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = arr.length;

        int[] maxOfMin = new int[n + 1];
        int[] left = new int[n + 1];
        int[] right = new int[n + 1];

        Arrays.fill(left, -1);
        Arrays.fill(right, n);

        for(int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();

        for(int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i] ) {
                stack.pop();
            }

            if(!stack.isEmpty()) {
                right[i] = stack.peek();
            }

            stack.push(i);
        }

        Arrays.fill(maxOfMin, 0);

        // Fill answer array by comparing minimums of all lengths computed using left[] and right[]
        for(int i = 0; i < n; i++) {
            // length of the interval
            int len = right[i] - left[i] - 1;

            // arr[i] is a possible answer for this length 'len' interval, check if arr[i] is
            // more than max for 'len'
            maxOfMin[len] = Math.max(maxOfMin[len], arr[i]);
        }

        for(int i = n - 1; i >= 1; i--) {
            maxOfMin[i] = Math.max(maxOfMin[i], maxOfMin[i + 1]);
        }
        return Arrays.stream(maxOfMin, 1, n).toArray();
    }

    /**
     * Using Bruteforce: The idea is to calculate the minimum of every window separately and
     * print the maximum of each window size.
     *
     * 1. Traverse a loop on K from1 till N
     *      - Initialize a variable maxOfMin = INT_MIN
     *      - Initialize a nested on i loop from 0 till N – K
     *      - Initialize a variable min = arr[i]
     *          a. Initialize another nested loop on j from 1 till K
     *              - If min > arr[i + j]
     *                  - Update min = arr[i + j]
     *          b. If maxOfMin < min
     *              - Update maxOfMin = min
     *      - Print maxOfMin for the window of size K.
     *
     * TC: O(n ^ 3)
     * SC: O(1)
     *
     * @param arr
     * @return
     */
    private static void maxOfMin(int[] arr) {
        // consider all windows of different sizes starting from 1
        for (int k = 1; k <= arr.length; k++) {
            // initialize max of min for current window size k
            int maxOfMin = Integer.MIN_VALUE;

            // traverse through all the windows of current size k
            for(int i = 0; i <= arr.length - k; i++) {
                // find min of current window
                int min = arr[i];
                for(int j = 1; j < k; j++) {
                    if(arr[i + j] < min) {
                        min = arr[i + j];
                    }
                }

                if(min > maxOfMin) {
                    maxOfMin = min;
                }
            }

            System.out.print(maxOfMin + " ");
        }
    }

}
