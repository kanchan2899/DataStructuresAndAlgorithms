package com.dsalgo.sort;

import java.util.Arrays;

// https://www.geeksforgeeks.org/find-number-pairs-xy-yx/
public class NumberOfPairs {
    public static void main(String[] args) {
        int[] x = {2, 1, 6};
        int[] y = {1, 5};
        System.out.println(numberOfPairs(x, x.length, y, y.length));
        System.out.println(numberOfPairs1(x, x.length, y, y.length));
    }

    private static long numberOfPairs1(int[] x, int m, int[] y, int n) {
        int zeroes = 0, ones = 0, twos = 0, threes = 0, fours = 0;
        long totalPairs = 0;
        Arrays.sort(x);
        Arrays.sort(y);

        for(int i = 0; i < n; i++) {
            if(y[i] == 0)   zeroes++;
            if(y[i] == 1)   ones++;
            if(y[i] == 2)   twos++;
            if(y[i] == 3)   threes++;
            if(y[i] == 4)   fours++;
        }

        for(int i = 0; i < m; i++) {
            if(x[i] == 0) {
                continue;
            } else if(x[i] == 1) {
                totalPairs += zeroes;
            } else if (x[i] == 2) {
                int index = getIndex(y, n, 2);
                if(index != -1) {
                    totalPairs += n - index;
                }
                totalPairs -= threes;
                totalPairs -= fours;
                totalPairs += ones + zeroes;
            } else {
                int index = getIndex(y, n, x[i]);
                if(index != -1) {
                    totalPairs += n - index;
                    }
                totalPairs += ones + zeroes;
                if(x[i] == 3) {
                    totalPairs += twos;
                }
            }
        }

        return totalPairs;
    }

    private static int getIndex(int[] arr, int n, int element) {
        int low = 0, high = n - 1, index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] > element) {
                index = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return index;
    }

    /**
     * Using Bruteforce: Loop through element of x and then loop through elements of y. Increment
     * count if x^y > y^x. Return the count.
     *
     * TC: O(m * n)
     * SC: O(1)
     *
     * @param x
     * @param m
     * @param y
     * @param n
     * @return
     */
    private static int numberOfPairs(int[] x, int m, int[] y, int n) {
        int pairs = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(Math.pow(x[i], y[j]) > Math.pow(y[j], x[i])) {
                    pairs++;
                }
            }
        }
        return pairs;
    }
}
