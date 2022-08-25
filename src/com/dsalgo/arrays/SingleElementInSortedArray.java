package com.dsalgo.arrays;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/single-element-in-a-sorted-array/
public class SingleElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,8,8};
//        System.out.println(singleNonDuplicate1(nums));
        System.out.println(singleNonDuplicate2(nums));
    }

    private static int singleNonDuplicate2(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start < end){
            int mid = start + (end - start) / 2;
            if((mid % 2 == 0 && nums[mid] == nums[mid + 1]) || (mid % 2 == 1 && nums[mid] == nums[mid - 1])){
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }

    public static int singleNonDuplicate1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum2 = 0;
        for(int x : nums){
            set.add(x);
            sum2 += x;
        }
        int sum1 = 0;
        for(Integer x : set){
            sum1 += x * 2;
        }

        return sum1 - sum2;
    }
}
