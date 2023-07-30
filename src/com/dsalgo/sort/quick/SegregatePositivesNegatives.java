package com.dsalgo.sort.quick;

import java.util.Arrays;

public class SegregatePositivesNegatives {
    public static void main(String[] args) {
        int[] arr = {9, -1, -4, 7, -3, 2, 5, -4};
        segregatePosNeg(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Using Quick Sort's Partition algo: Increment i until arr[i] < 0. Decrement j until arr[j]
     * >= 0. Then swap arr[i] and arr[j]. When i >= j, break out of the loop.
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param arr
     */
    private static void segregatePosNeg(int[] arr) {
        int i = -1, j = arr.length;

        while(true) {
            do {
                i++;
            } while (arr[i] < 0);

            do {
                j--;
            } while (arr[j] >= 0);

            if(i >= j) {
                return;
            }

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
