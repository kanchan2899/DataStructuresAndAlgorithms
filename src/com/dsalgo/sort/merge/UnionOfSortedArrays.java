package com.dsalgo.sort.merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnionOfSortedArrays {
    public static void main(String[] args) {
        int[] a = {2, 3, 3, 3, 4, 4};
        int[] b = {4, 4};

        System.out.println(union(a, b));
        System.out.println(union1(a, b));
    }


    /**
     * Bruteforce algo: Create a new array c and copy a's value in it. Then copy b's values in it.
     * Sort the array c and traverse c array. If previous element is not equal to current element,
     * add it to the list. Return list at the end.
     *
     * TC: O((m+n) * log(m+n))
     * SC: O(m+n)
     *
     * @param a
     * @param b
     * @return
     */
    private static List<Integer> union(int[] a, int[] b) {
        List<Integer> union = new ArrayList<>();
        int m = a.length;
        int n = b.length;
        int[] c = new int[m + n];

        for(int i = 0; i < m; i++) {
            c[i] = a[i];
        }

        for(int i = 0; i < n; i++) {
            c[m + i] = b[i];
        }

        Arrays.sort(c);

        for(int i = 0; i < m+n; i++) {
            if(i == 0 || c[i] != c[i - 1]) {
                union.add(c[i]);
            }
        }
        return union;
    }


    /**
     * Using merge algo:
     *
     * 1. Start a while loop for both arrays together -> i < a.length && j < b.length
     * 2. Skip the duplicate element in array a and continue
     * 3. Skip the duplicate element in array b and continue
     * 4. If a[i] < b[i], add a[i] to list and increment i
     * 5. If a[i] > b[i], add b[j] to list and increment j
     * 6. If a[i] == b[j], add either of them to list and increment i and j
     * 7. Add rest of unique elements from array a
     * 8. Add rest of unique elements from array b
     *
     * TC: O(m + n)
     * SC: O(1)
     * @param a
     * @param b
     * @return
     */
    private static List<Integer> union1(int[] a, int[] b) {
        int i = 0, j = 0;
        List<Integer> union = new ArrayList<>();
        while (i < a.length && j < b.length) {
            // Skip duplicate elements in array a
            if(i > 0 && a[i] == a[i - 1]) {
                i++;
                continue;
            }
            // Skip duplicate elements in array a
            if(j > 0 && b[j] == b[j - 1]) {
                j++;
                continue;
            }

            if(a[i] < b[j]) {
                union.add(a[i]);
                i++;
            } else if(a[i] > b[j]) {
                union.add(b[j]);
                j++;
            } else {
                union.add(a[i]);
                i++;
                j++;
            }
        }

        while (i < a.length) {
            if(i == 0 || (i > 0 && a[i] != a[i - 1])) {
                union.add(a[i]);
            }
            i++;
        }
        while (j < b.length) {
            if(j == 0 || (j > 0 && b[j] != b[j - 1])) {
                union.add(b[j]);
            }
            j++;
        }
        return union;
    }
}
