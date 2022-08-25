package com.dsalgo.arrays;

import java.util.Arrays;

// https://leetcode.com/problems/rotate-array/
public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {-1};
        int k = 2;
        System.out.println(Arrays.toString(rotate1(nums, k)));
        System.out.println(Arrays.toString(rotate2(nums, k)));
        System.out.println(Arrays.toString(rotate3(nums, k)));
    }

    private static int[] rotate3(int[] nums, int k) {
        // Solution 3 - O(n)
        // Reverse the whole array. Reverse the array from 0 till k - 1 and then reverse the array from k till n - 1
        int n = nums.length;
        k = k % n; // For n == 1 && k > n
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        return nums;
    }

    private static void reverse(int[] nums, int start, int end) {
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static int[] rotate1(int[] nums, int k) {
        // Solution 1 - O(n * k) TC
        // For each rotation, save the last element, then assign previous element to the current element. Assign last element to the first element
        while(k != 0){
            int lastElement = nums[nums.length - 1];
            for(int i = nums.length - 1; i > 0; i--){
                nums[i] = nums[i - 1];
            }
            nums[0] = lastElement;
            k--;
        }
        return nums;
    }

    public static int[] rotate2(int[] nums, int k) {
        // Solution 2 - O(n) TC & O(n) SC
        // Create a new array and add values at index arr[(i + k) % n] from num[i]
        int[] arr = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            arr[(i + k) % nums.length] = nums[i];
        }
        return arr;
    }
}
