package com.dsalgo.arrays;

import java.util.ArrayList;
import java.util.Arrays;


// https://leetcode.com/problems/create-target-array-in-the-given-order/
public class CreateTargetArrayInTheGivenOrder {
    public static void main(String[] args) {
        int[][] nums = {{2,4,1,3,6}, {1,2,3,4,0}, {1}};
        int[][] index = {{0,1,6,2,1}, {0,1,2,3,0}, {0}};
        for(int i = 0; i < nums.length; i++){
//            System.out.println(Arrays.toString(createTargetArray1(nums[i], index[i])));
            System.out.println(Arrays.toString(createTargetArray2(new int[]{2,4,1,3,6}, new int[]{0,1,6,2,1})));
        }
    }
    public static int[] createTargetArray1(int[] nums, int[] index) {
        int[] target = new int[nums.length];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            list.add(index[i], nums[i]);
        }
        for(int i = 0; i < target.length; i++){
            target[i] = list.get(i);
        }
        return target;
    }

    public static int[] createTargetArray2(int[] nums, int[] index) {
        int[] target = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            for(int j = nums.length - 1; j > index[i]; j--){
                target[j] = target[j-1];
            }
            target[index[i]] = nums[i];
        }
        return target;
    }
}
