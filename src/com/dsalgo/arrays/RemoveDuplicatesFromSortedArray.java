package com.dsalgo.arrays;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 2, 3, 4, 5, 5};
        System.out.println("Number of unique elements is " + removeDuplicates(nums));
    }
    public  static int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return nums.length;
        }
        /*
        int left = 1;
        for(int right = 1; right < nums.length; right++){
            if(nums[right] != nums[right - 1]){
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
        */
        int left = 0;
        for(int right = 0; right < nums.length - 1; right++){
            if(nums[right] != nums[right+1]){
                nums[++left] = nums[right + 1];
            }
        }
        return left+1;
    }
}
