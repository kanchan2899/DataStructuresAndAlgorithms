package com.dsalgo.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/sort-colors/
public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        System.out.println(Arrays.toString(sortColors1(nums)));
        System.out.println(Arrays.toString(sortColors2(nums)));
        System.out.println(Arrays.toString(sortColors3(nums)));
    }

    // Solution 3 - O(n) TC
    // Using counting sort
    private static int[] sortColors3(int[] nums) {
        int[] count = new int[3];
        int[] sortedColors = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            count[nums[i]]++;
        }

        for(int i = 1; i < count.length; i++){
            count[i] += count[i-1];
        }

        for(int i = nums.length - 1; i >= 0; i--){
            sortedColors[count[nums[i]] - 1] = nums[i];
            --count[nums[i]];
        }

        return sortedColors;
    }

    // Solution 2 - O(n) TC
    // Instead of a map, store the count in 3 variables and reassign the array with the right value based on the count
    private static int[] sortColors2(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0)    count0++;
            else if (nums[i] == 1)    count1++;
            else count2++;
        }
        int i = 0;
        while(i < nums.length){
            while(count0 != 0){
                nums[i] = 0;
                count0--;
                i++;
            }
            while(count1 != 0){
                nums[i] = 1;
                count1--;
                i++;
            }
            while(count2 != 0){
                nums[i] = 2;
                count2--;
                i++;
            }
        }
        return nums;
    }

    // Solution 1 - O(n) TC
    // Save the count of 0, 1, 2 in a map and reassign the array with the right value based on the count
    public static int[] sortColors1(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int i = 0; i < 3; i++){
            countMap.put(i, 0);
        }
        for(int i = 0; i < arr.length; i++){
            if(countMap.containsKey(arr[i])){
                countMap.replace(arr[i], countMap.get(arr[i]) + 1);
            }
        }
        int j = 0;
        int i = 0;
        while(i < arr.length){
            int count = countMap.get(j);
            while(count != 0){
                arr[i] = j;
                count--;
                i++;
            }
            j++;
        }
        return arr;
    }
}
