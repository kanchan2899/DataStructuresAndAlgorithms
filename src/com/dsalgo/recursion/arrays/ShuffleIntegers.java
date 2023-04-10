package com.dsalgo.recursion.arrays;

import java.util.Arrays;

public class ShuffleIntegers {
    static int x = 0;
    public static void main(String[] args) {
        long[] a = {1, 2, 9, 15};
        System.out.println("" + a.length/2);
        shuffleArray(a, a.length);
        System.out.println(Arrays.toString(a));

    }

    static void shuffleArray(long arr[], int n)
    {
        shuffle_helper(arr, n-1, n);
    }

    private static void shuffle_helper(long[] arr, int i, int n) {
        if(i == Math.ceil(n/2.0 - 1)) return;

        long a = arr[i - n/2];
        long b = arr[i];

        shuffle_helper(arr, i - 1, n);

        arr[i - n/2 + x] = a;
        arr[i - n/2 + 1 + x] = b;
        x++;

    }
}
