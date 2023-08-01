package com.dsalgo.sort.merge;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3, 4};
        int[] b = {1, 5, 6};

        System.out.println(Arrays.toString(merge(a, b)));
        System.out.println(Arrays.toString(merge1(a, b)));

    }

    /**
     * Optimized solution: Traverse both array simultaneously with two variables i and j, where i and j
     * represent the index of array a and b respectively. Compare a[i] and b[j] and if b[j] is smaller than
     * a[i], place b[j] in the new array and increment j. Otherwise, place a[i] in new array and increment
     * i.
     *
     * TC: O(m+n)
     * SC: O(m+n)
     *
     * @param a
     * @param b
     * @return
     */
    private static int[] merge1(int[] a, int[] b) {
        int[] merged = new int[a.length + b.length];
        int i = 0, j = 0, k = 0, m = a.length, n = b.length;

        while (i < m && j < n) {
            if(a[i] <= b[j]) {
                merged[k] = a[i];
                i++;
            } else {
                merged[k] = b[j];
                j++;
            }
            k++;
        }

        while (i < m) {
            merged[k] = a[i];
            k++;
            i++;
        }

        while (j < n) {
            merged[k] = b[j];
            j++;
            k++;
        }
        return merged;
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
