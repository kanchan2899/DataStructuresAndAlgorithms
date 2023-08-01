package com.dsalgo.sort.merge;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfSortedArrays {
    public static void main(String[] args) {
        int[] a = {1, 20, 20, 40, 60};
        int[] b = {10, 20, 20, 20, 60, 80};

        System.out.println(intersection(a, b));
        System.out.println(intersection1(a, b));
    }

    /**
     * Bruteforce: For every element in array a, check if it exists in array b
     *
     * TC: O(n^2)
     * SC: O(1)
     *
     * @param a
     * @param b
     * @return
     */
    private static List<Integer> intersection(int[] a, int[] b) {
        List<Integer> intersection = new ArrayList<>();
        for(int i = 0; i < a.length; i++) {
            if(i > 0 && a[i] == a[i - 1]) {
                continue;
            }
            for(int j = 0; j < b.length; j++) {
                if(a[i] == b[j]) {
                    intersection.add(a[i]);
                    break;
                }
            }
        }
        return intersection;
    }

    /**
     * Using merge algo: Since the two arrays are sorted, we can use merge algo.
     *
     * 1. Iterate in while loop till any of the one array is finished.
     * 2. In each iteration we look for smaller of the two elements from both
     * the array and increase its pointer because it will not be in other list,
     * hence not part of intersection.
     * 3. For intersection, if both the elements are equal we print it and
     * increment both pointer only if it is not same as the last element printed in intersection.
     *
     * TC: O(min(m, n))
     * SC: O(1)
     * @param a
     * @param b
     * @return
     */
    private static List<Integer> intersection1(int[] a, int[] b) {
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            // To skip duplicate elements in array a
            if(i > 0 && a[i] == a[i - 1]) {
                i++;
                continue;
            }
            if(a[i] < b[j]) {
                i++;
            } else if(a[i] > b[j]) {
                j++;
            } else {
                list.add(a[i]);
                i++;
                j++;
            }
        }
        return list;
    }
}
