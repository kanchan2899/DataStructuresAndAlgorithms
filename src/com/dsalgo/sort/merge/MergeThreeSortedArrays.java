package com.dsalgo.sort.merge;

import java.util.ArrayList;

public class MergeThreeSortedArrays {
    public static void main(String[] args) {
        int[] a = {1, 1, 2, 3, 3, 4};
        int[] b = {1, 2, 2, 3, 5};
        int[] c = {1, 2, 3, 3, 4, 4, 5};

        System.out.println(merge3sorted(a, b, c));
    }

    /**
     * Bruteforce: Merge first two arrays using Merge Sort's merge algorithm, that'll take some extra
     * space. Then, merge the merged array and the third array and store the results in a arraylist
     * at the same time;
     *
     * TC: O(a.length + b.length + c.length)
     * SC: O(a.length + b.length)
     * @param a
     * @param b
     * @param c
     * @return
     */
    static ArrayList<Integer> merge3sorted(int a[], int b[], int c[])
    {
        ArrayList<Integer> list = new ArrayList<>();
        int aL = a.length;
        int bL = b.length;
        int cL = c.length;

        int[] ab = new int[aL + bL];
        int abL = ab.length;

        int i = 0, j = 0, k = 0;

        while(i < aL && j < bL) {
            if(a[i] <= b[j]) {
                ab[k] = a[i];
                i++;
                k++;
            } else {
                ab[k] = b[j];
                j++;
                k++;
            }
        }

        while(i < aL) {
            ab[k] = a[i];
            i++;
            k++;
        }

        while(j < bL) {
            ab[k] = b[j];
            j++;
            k++;
        }

        k = 0;
        i = 0;
        j = 0;

        while(i < abL && j < cL) {
            if(ab[i] <= c[j]) {
                list.add(k, ab[i]);
                k++;
                i++;
            } else {
                list.add(k, c[j]);
                k++;
                j++;
            }
        }

        while(i < abL) {
            list.add(k, ab[i]);
            k++;
            i++;
        }

        while(j < cL) {
            list.add(k, c[j]);
            j++;
            k++;
        }
        return list;
    }
}
