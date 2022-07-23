package com.dsalgo.arrays;

import java.util.Arrays;

// https://leetcode.com/problems/find-pivot-index/
class FindPivotIndex {
    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums));
    }
    public static int pivotIndex(int[] nums) {
        int[] p = new int[nums.length + 1];
        p[0] = 0;
        for(int i = 0; i < nums.length; i++){
            p[i+1] = p[i] + nums[i];
        }
        for(int j = 0; j < p.length-1; j++){
            int left = p[j];
            int right = p[p.length - 1] - p[j] - nums[j];
            if(left == right) {
                return j;
            } else if (right < left) {
                return -1;
            }
        }
        return -1;
    }
}