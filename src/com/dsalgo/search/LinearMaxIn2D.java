package com.dsalgo.search;

public class LinearMaxIn2D {
    public static void main(String[] args) {
        int[][] arr = {
                {23, 4, 6},
                {5, 87, 10, 63},
                {12, 37},
                {98, 76, 41, 80}
        };
        System.out.println(max(arr));
    }

    private static int max(int[][] arr) {
        int max = arr[0][0];
        for (int[] ints : arr)
            for (int ele : ints) {
                if(ele > max) max = ele;
            }
        return max;
    }
}
