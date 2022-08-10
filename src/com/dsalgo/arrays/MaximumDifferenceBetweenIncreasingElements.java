package com.dsalgo.arrays;

import java.util.Arrays;

public class MaximumDifferenceBetweenIncreasingElements {
    public static void main(String[] args) {
        int[][] prices = {{7,1,5,4}, {9,4,3,2}, {1,5,2,10}};
        for(int[] x: prices){
            System.out.println("Maximum difference between increasing elements " + Arrays.toString(x) + " is " + maximumDifference(x));
        }
    }
    public static int maximumDifference(int[] nums) {
        int minSoFar = nums[0];
        int max = -1;
        for(int i = 0; i < nums.length; i++){
            if(minSoFar > nums[i]){
                minSoFar = nums[i];
            }
            int currentMax = nums[i] - minSoFar;
            if(nums[i] > minSoFar){
                if(currentMax > max){
                    max = currentMax;
                }
            }
        }
        return max;
    }
}
