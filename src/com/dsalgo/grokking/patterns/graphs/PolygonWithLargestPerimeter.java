package com.dsalgo.grokking.patterns.graphs;

import java.util.Arrays;

// https://leetcode.com/problems/find-polygon-with-the-largest-perimeter/
public class PolygonWithLargestPerimeter {
    public static void main(String[] args) {
        int[] nums = {1, 12, 1, 2, 5, 50, 3};
        System.out.println(largestPerimeter(nums));
        System.out.println(largestPerimeter1(nums));
    }

    private static long largestPerimeter1(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;
        long largestPerimeter = -1;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < sum) {
                largestPerimeter = nums[i] + sum;
            }
            sum += nums[i];
        }

        return largestPerimeter;
    }

    private static long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;

        for(int n : nums) {
            sum += n;
        }

        for(int i = nums.length - 1; i >= 2; i--) {
            sum -= nums[i];

            if(sum > nums[i]) {
                return sum + nums[i];
            }
        }
        return -1;
    }
}
