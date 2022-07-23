package com.dsalgo.sort.cycle;

// https://leetcode.com/problems/find-the-duplicate-number/
public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        int[] nums = {7, 3, 4, 5, 5, 1, 2, 6};
        System.out.println(findDuplicateNumber1(nums));
        System.out.println(findDuplicateNumber2(nums));
    }

    private static int findDuplicateNumber2(int[] nums) {
        int i = 0;
        while(i < nums.length){
            if(nums[i] != i + 1){
                int correctIndex = nums[i] - 1;
                if(nums[i] != nums[correctIndex]){
                    swap(nums, i, correctIndex);
                } else {
                    return nums[i];
                }
            } else {
                i++;
            }
        }
        return -1;
    }

    private static int findDuplicateNumber1(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int correctIndex = nums[i] - 1;
            if(nums[i] != nums[correctIndex]){
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }
        return nums[nums.length - 1];
    }
    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
