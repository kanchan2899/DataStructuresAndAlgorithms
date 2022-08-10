package com.dsalgo.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/contains-duplicate/
public class ContainsDuplicates {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4, 1, 2, 3, 5}));
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4}));

    }
    public static boolean containsDuplicate(int[] nums) {
        // Solution 1
        /*
        Set<Integer> uniqueNums = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(!uniqueNums.add(nums[i])){
                return true;
            }
        }
        return false;
         */

        // Solution 2
        /*
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]){
                return true;
            }
        }
        return false;
        */

        // Solution 3
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            if((nums[i] ^ nums[i-1]) == 0){
                return true;
            }
        }
        return false;
    }
}
