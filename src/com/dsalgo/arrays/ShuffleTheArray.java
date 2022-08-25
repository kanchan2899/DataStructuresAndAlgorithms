package com.dsalgo.arrays;

import java.util.Arrays;

public class ShuffleTheArray {
    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 3, 4, 7};
        int n = 3;
        System.out.println(Arrays.toString(shuffle(nums, n)));
    }
    public static int[] shuffle(int[] nums, int n) {
        int[] x = new int[2 * n];
        int k = 0;
        for(int i = 0; i < n; i++){
            x[k++] = nums[i];
            x[k++] = nums[n + i];
        }
        return x;
    }
}
