package com.dsalgo.arrays;

import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodPairs {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 1, 3};
        System.out.println(numIdenticalPairs1(nums));
        System.out.println(numIdenticalPairs2(nums));
    }

    private static int numIdenticalPairs2(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                if(nums[i] == nums[j] && j != i){
                    count++;
                }
            }
        }
        return count;
    }

    public static int numIdenticalPairs1(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int countIdenticalPairs = 0;
        for(int i = 0; i < nums.length; i++){
            if(!count.containsKey(nums[i])){
                count.put(nums[i], 1);
            } else {
                count.replace(nums[i], count.get(nums[i]) + 1);
            }
        }

        for(Integer key: count.keySet()){
            int c = count.get(key);
            countIdenticalPairs += c * (c - 1) / 2;
        }
        return countIdenticalPairs;
    }
}
