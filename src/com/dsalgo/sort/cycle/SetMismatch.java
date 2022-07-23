package com.dsalgo.sort.cycle;

import java.util.Arrays;

public class SetMismatch {
    public static void main(String[] args) {
        int[] nums = {2, 2, 3};
        System.out.println(Arrays.toString(setMismatch(nums)));
    }

    private static int[] setMismatch(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int correctIndex = nums[i] - 1;
            if(nums[i] != nums[correctIndex]){
               swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }
        for(int k = 0; k < nums.length; k++){
            if(nums[k] != (k + 1)){
                return new int[]{nums[k], k+1};
            }
        }
        return new int[]{-1, -1};
    }

    private static void swap(int[] nums, int i, int correctIndex) {
        int temp = nums[i];
        nums[i] = nums[correctIndex];
        nums[correctIndex] = nums[i];
    }
}
