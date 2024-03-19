package com.dsalgo.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RearrangeArrayElementsBySign {
    public static void main(String[] args) {
        int[] nums = {3,1,-2,-5,2,-4};
        System.out.println(Arrays.toString(rearrangeArray(nums)));
        System.out.println(Arrays.toString(rearrangeArray1(nums)));
    }

    private static int[] rearrangeArray1(int[] nums) {
         List<Integer> positives = new ArrayList<>();
         List<Integer> negatives = new ArrayList<>();
         List<Integer> res = new ArrayList<>();

         for(int n : nums) {
             if(n > 0) {
                 positives.add(n);
             } else {
                 negatives.add(n);
             }
         }

         int i = 0, j = 0;

         while(j < nums.length/2) {
             res.add(positives.get(i));
             i++;
             res.add(negatives.get(j));
             j++;
         }

         return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int pos = 0, neg = 1;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ans[pos] = nums[i];
                pos += 2;
            } else {
                ans[neg] = nums[i];
                neg += 2;
            }
        }
        return ans;
    }
}
