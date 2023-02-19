package com.dsalgo.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
public class TwoSumII {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 13;
        System.out.println(Arrays.toString(twoSum1(arr, target)));
        System.out.println(Arrays.toString(twoSum2(arr, target)));
        System.out.println(Arrays.toString(twoSum3(arr, target)));
    }

    private static int[] twoSum3(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] x = new int[2];
        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(target - arr[i])){
                x[0] = map.get(target - arr[i]) + 1;
                x[1] = i + 1;
                break;
            }
            map.put(arr[i], i);
        }
        return x;
    }

    private static int[] twoSum2(int[] arr, int target) {
        int[] x = new int[2];
        int i = 0;
        int j = arr.length - 1;
        while(i < j){
            int sum = arr[i] + arr[j];
            if(sum == target){
                x[0] = i + 1;
                x[1] = j + 1;
                break;
            } else if(sum < target){
                i++;
            } else {
                j--;
            }
        }
        return x;
    }

    // Solution 1 - O(n * n) TC
    // 2 For loops to check if the sum is equal to target
    public static int[] twoSum1(int[] numbers, int target) {
        int[] x = new int[2];
        for(int i = 0; i < numbers.length; i++){
            for(int j = i + 1; j < numbers.length; j++){
                if(numbers[i] + numbers[j] == target){
                    x[0] = i + 1;
                    x[1] = j + 1;
                }
            }
        }
        return x;
    }
}
