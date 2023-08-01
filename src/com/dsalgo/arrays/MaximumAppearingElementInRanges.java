package com.dsalgo.arrays;

// https://www.geeksforgeeks.org/maximum-occurred-integer-n-ranges/
public class MaximumAppearingElementInRanges {
    public static void main(String[] args) {
        int[] left = {1, 2, 4};
        int[] right = {4, 5, 7};
        System.out.println(maxAppear(left, right, left.length));
        System.out.println(maxAppear1(left, right, left.length));
    }

    /**
     * Bruteforce: Create a frequency array of size MAX, which is the maximum value that left and/or
     * right array can hole. Start a loop i from 0 to n-1. Start an inner loop j from left[i]
     * to right[i] and update the frequency of j in frequency array. Initialize max_appearing_element
     * as 0. Iterate through frequency array, if freq[i] > max_appearing_element,
     * assign i to max_appearing_element
     *
     * Return max_appearing_element
     *
     * TC: O(n * MAX), where MAX is 100 here
     * SC: O(MAX) -> frequency array of MAX size
     * @param left
     * @param right
     * @param n
     * @return
     */
    static int maxAppear(int[] left, int[] right, int n) {
        int[] frequency = new int[100];

        for(int i = 0; i < n; i++) {
            for(int j = left[i]; j <= right[i]; j++) {
                frequency[j] += 1;
            }
        }

        int maxAppearingElement = 0;
        for(int i = 1; i < frequency.length; i++) {
            if(frequency[i] > maxAppearingElement) {
                maxAppearingElement = i;
            }
        }
        return maxAppearingElement;
    }

    /**
     * Using prefix sum: The idea is to use the Difference array technique.
     * Create a vector initialized with value zero.
     * Iterate through every range and mark the presence of the beginning of every range by
     * incrementing the start of the range with one i.e. arr[L[i]]++ and mark the end of the range
     * by decrementing at index one greater than the end of range by one i.e. arr[R[i]+1]–.
     * Now when computing the prefix sum, Since the beginning is marked with one,
     * all the values after beginning will be incremented by one.
     * Now as increment is only targeted only till the end of the range,
     * the decrement on index R[i]+1 prevents that for every range i.
     */
    static int maxAppear1(int[] left, int[] right, int n) {
        int[] freq = new int[100+1];
        int max_appearing = 0;

        for(int i = 0; i < n; i++) {
            freq[left[i]]++;
            freq[right[i]+1]--;
        }

        for(int i = 1; i <= 100; i++) {

            freq[i] = freq[i] + freq[i-1];

            if(freq[i] > freq[max_appearing]) {
                max_appearing = i;
            }
        }

        return max_appearing;
    }
}
