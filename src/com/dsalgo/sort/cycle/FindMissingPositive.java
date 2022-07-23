package com.dsalgo.sort.cycle;

// https://leetcode.com/problems/first-missing-positive/
public class FindMissingPositive {
    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        System.out.println(smallestMissingPositive(nums));
    }

    private static int smallestMissingPositive(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int correct = nums[i] - 1;
            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correct]){
                swap(nums, i, correct);
            } else {
                i++;
            }
        }
        int j;
        for(j = 0; j < nums.length; j++){
            if(nums[j] != j + 1){
                return j + 1;
            }
        }
        return nums.length + 1;
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
