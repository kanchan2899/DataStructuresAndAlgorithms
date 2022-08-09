package com.dsalgo.arrays;

// https://leetcode.com/problems/single-number/
public class SingleNumber {
    public static void main(String[] args) {
        int[][] nums = {{1, 2, 1}, {1, 1, 4, 2, 2, 3, 4}, {1}};
        for(int i = 0; i < nums.length; i++){
            System.out.println("Single number in the array is " + singleNumber(nums[i]));
        }
    }

    private static int singleNumber(int[] nums) {
        /*
        XOR properties: x ^ 0 = x && x ^ x = 0
         */
        int xor = 0;
        for(int i: nums){
            xor = xor ^ i;
            System.out.println(xor);
        }
        return xor;
    }
}
