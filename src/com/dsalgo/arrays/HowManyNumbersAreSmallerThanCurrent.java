package com.dsalgo.arrays;

import java.util.Arrays;

// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
public class HowManyNumbersAreSmallerThanCurrent {
    public static void main(String[] args) {
        int[][] test = {{8,1,2,2,3}, {6,5,4,8}, {7,7,7,7}};
        for(int i = 0; i < test.length; i++){
            System.out.println("Count of numbers smaller than the current number " + Arrays.toString(smallerNumbersThanCurrent(test[i])));
        }

    }

    private static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] min = new int[nums.length];
        int count;
        for(int i = 0; i < nums.length; i++){
            count = 0;
            for(int j = 0; j < nums.length; j++){
                if(i != j){
                    if(nums[i] > nums[j]){
                        count++;
                    }
                }
            }
            min[i] = count;
        }
        return min;
    }
}
