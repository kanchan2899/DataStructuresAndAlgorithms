package com.dsalgo.sort;

public class MaximumProductOfThreeNumbers {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 1};
        int[] nums1 = {-100,-98,-1,2,3,4};
        System.out.println(maximumProductOf3Numbers(nums));
        System.out.println(maximumProductOf3Numbers(nums1));
    }

    private static int maximumProductOf3Numbers(int[] nums) {
        if(nums.length < 3) {
            return -1;
        }
        if(nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        }
        int lastIndex = nums.length - 1;
        int maxProduct = 1;
        for(int i = 0; i < 3; i++) {
            int index =  findMax(nums, lastIndex);
            swap(nums, index, lastIndex);
            maxProduct *= nums[lastIndex];
            lastIndex--;
        }
        return maxProduct;
    }

    private static void swap(int[] nums, int index, int lastIndex) {
        int temp = nums[index];
        nums[index] = nums[lastIndex];
        nums[lastIndex] = temp;
    }

    private static int findMax(int[] nums, int lastIndex) {
        int maxElement = Integer.MIN_VALUE;
        int maxIndex = 0;
        for(int i = 0; i <= lastIndex; i++) {
            if(nums[i] > maxElement) {
                maxElement = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
