package com.dsalgo.search.binary;

// https://leetcode.com/problems/split-array-largest-sum/
public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = {1, 4, 4};
        int m = 3;
        System.out.println(splitArray(nums, m));
    }
    static public int splitArray(int[] nums, int m){
        int start = 0;
        int end = 0;
        for(int i = 0; i < nums.length; i++ ){
            // In the end of loop, start will contain the max item from the array
            start = Math.max(start, nums[i]);
            end += nums[i];
        }

        // Binary Search
        while(start < end){
            // Try for the middle as potential answer
            int mid = start + (end - start) / 2;

            // Calculate how many pieces you can divide this in this max sum
            int sum = 0;
            int pieces = 1;
            for(int num: nums){
                if(sum + num > mid){
                    // You cannot add this in sub-array, make a new one
                    // Say you can add this num in new subarray, then sum = num
                    sum = num;
                    pieces++;
                } else {
                    sum += num;
                }
            }

            if(pieces > m){
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end; // return start or mid as they will be same;
    }
}
