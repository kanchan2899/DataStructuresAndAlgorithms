package com.dsalgo.sort.radix;

import java.util.Arrays;

// https://www.geeksforgeeks.org/radix-sort/?ref=gcse
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {319, 220, 101, 51, 9, 6, 99};
        radixSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Radix sort: The idea of the Radix sort is to do digit by digit sort starting from the least
     * significant digit to the most significant digit. Radix sort uses counting sort as a
     * subroutine to sort.
     *
     * Counting sort is a linear time sorting algorithm that sort in O(n + k) time when elements are
     * in the range from 1 to k. But we can't use counting sort when the elements are in the range
     * from 1 to n^2 because then counting sort will take O(n^2) time, which is worse than any
     * comparison-based sorting algorithm.
     *
     * TC: O(d * (n + b)), where d is the number of digits in input numbers, d = O(log b(k))
     * b is the base for representing numbers, k <= n^c where c is a constant.
     * => time complexity becomes O(nLogb(n)), which still doesn't beat comparison-based sorting algo.
     *
     * What if we make the value of b larger? What should be the value of b to make the time complexity
     * linear?
     * If we set b as n, we get the time complexity as O(n). In other words, we can sort an array of
     * integers with a range from 1 to n^c if the numbers are represented in base n (or every digit
     * takes log 2(n) bits)
     *
     *
     *
     * @param arr
     * @param n
     */
    private static void radixSort(int[] arr, int n) {
        // find the maximum number to know number of digits
        int max = getMax(arr, n);

        // do counting sort for every digit
        // note that instead of passing digit number, exp is passed. exp is 10^i, where i is current
        // digit number
        for(int exp = 1; max/exp > 0; exp *= 10) {
            countingSort(arr, n, exp);
        }
    }

    // method to do counting sort of arr[] according to the digit represented by exp.
    private static void countingSort(int[] arr, int n, int exp) {
        int[] count = new int[10];
        int[] output = new int[n];
        int i;

        Arrays.fill(count, 0);

        // store count of occurrences in count[]
        for(i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // change count[i] so that count[i] now contains actual position of this digit in output[]
        for(i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // build the output array
        for(i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for(i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }


    private static int getMax(int[] arr, int n) {
        int max = arr[0];
        for(int i = 0; i < n; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
