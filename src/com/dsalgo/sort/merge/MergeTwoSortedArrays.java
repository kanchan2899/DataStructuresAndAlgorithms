package com.dsalgo.sort.merge;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3, 4};
        int[] b = {1, 5, 6};

        System.out.println(Arrays.toString(merge(a, b)));
    }

    /**
     * Naive solution: Create a new array with length m+n.
     * Copy first array into the new array, then copy second array into the new array.
     * Sort the array and return it.
     *
     * TC: O((m+n) * log(m+n))
     * SC: O(m+n)
     * @param a
     * @param b
     * @return
     */
    private static int[] merge(int[] a, int[] b) {
        int[] merged = new int[a.length + b.length];

        for(int i = 0; i < a.length; i++) {
            merged[i] = a[i];
        }

        for(int i = 0; i < b.length; i++) {
            merged[a.length + i] = b[i];
        }

        Arrays.sort(merged);

        return merged;
    }
}
