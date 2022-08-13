package com.dsalgo.arrays;

import java.util.Arrays;

// https://leetcode.com/problems/build-array-from-permutation/
public class BuildArrayFromPermutation {
    public static void main(String[] args) {
        int[] n = {0,2,1,5,3,4};
        System.out.println(Arrays.toString(buildArray(n)));
    }
    public static int[] buildArray(int[] nums) {
        int[] arr = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            arr[i] = nums[nums[i]];
        }
        return arr;
    }
}
