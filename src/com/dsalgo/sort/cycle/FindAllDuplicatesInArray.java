package com.dsalgo.sort.cycle;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-all-duplicates-in-an-array/
public class FindAllDuplicatesInArray {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findAllDuplicates(nums));
    }

    private static List<Integer> findAllDuplicates(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int correctIndex = nums[i] - 1;
            if(nums[i] != nums[correctIndex]){
                swap(nums, i, correctIndex);
            } else { i++; }
        }
        List<Integer> duplicateNums = new ArrayList<>();
        for(int k = 0; k < nums.length; k++){
            if(nums[k] != k + 1){
                duplicateNums.add(nums[k]);
            }
        }
        return duplicateNums;
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
