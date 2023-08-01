package com.dsalgo.arrays;

public class RoofTop {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3};
        System.out.println("Max steps: " + maxStep(arr, arr.length));
    }

    /**
     * Bruteforce: If there is only one building, return 0 as there will be no steps to take.
     * Initialize max and count to 0. Start a for loop from 0 to n-2.
     * If current element is smaller than the next element, increment count and max should be maximum
     * of max and count. Else make count 0. Return max
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param a
     * @param n
     * @return
     */
    static int maxStep(int a[], int n)
    {
        if(n == 1) {
            return 0;
        }
        int max = 0;
        int count = 0;

        for(int i = 0; i < n-1; i++) {
            if(a[i] < a[i + 1]) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }
        return max;
    }
}
